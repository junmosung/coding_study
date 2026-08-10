---
name: pr
description: Safely prepare and open a pull request using an isolated Git worktree, current origin/main, atomic commits, validation, security and privacy review, severity scoring, push, and PR creation. Use when the user invokes /pr or $pr, asks to create or open a PR, or requests the complete pull-request workflow. Block PR creation whenever unresolved Critical findings exist.
---

# Safe Pull Request

Run the workflow in order. Treat validation and review as release gates, not suggestions.

## 1. Establish scope

- Inspect repository instructions and Git status.
- Identify requested changes and preserve unrelated user work.
- Confirm the remote and target branch. Default the target to `main` only when the repository provides no different convention.
- Do not commit, push, open a PR, merge, delete branches, or force-update refs beyond the user's requested scope.

## 2. Synchronize safely

- Fetch the target remote.
- Inspect divergence before changing refs.
- Update the local target branch with `--ff-only`. Never merge or rebase unexpected changes silently.
- If the primary worktree has uncommitted changes, do not discard or stash them without authorization. Preserve them and transfer only the scoped changes into the isolated worktree.
- Prefer authoring new PR changes directly in the isolated worktree. If this active task already created changes in the primary worktree and must transfer them, record the exact scoped paths and their original tracked/untracked state for later duplicate cleanup.

## 3. Create an isolated worktree

- Derive a unique branch such as `feat/<topic>`, `fix/<topic>`, `docs/<topic>`, `refactor/<topic>`, or `chore/<topic>`.
- Create a linked worktree from the updated target branch in a validated temporary or sibling path.
- Verify the new worktree branch, HEAD, and clean status before editing.
- Keep each active task in its own worktree. Never let two tasks write to the same branch or worktree.

## 4. Review and validate

Inspect the complete diff, including untracked files. Run repository-specific tests plus all safe relevant checks available, including:

- build, compile, test, lint, and formatting checks;
- `git diff --check` and changed-file review;
- documentation links and package/path consistency;
- secret, credential, private-key, personal-data, and local-path scanning;
- accidental generated files, IDE state, LLM-local state, and large binaries;
- regressions, destructive behavior, authorization boundaries, and missing validation.

Never claim a check passed if it was not run. Record unavailable checks explicitly.

## 5. Score findings

Use these severity scores:

| Severity | Score | Meaning | Gate |
|---|---:|---|---|
| Critical | 10 | Credential/private data exposure, destructive data loss, remote-code or auth bypass, corrupted target history, non-compiling main-path change, or another release-blocking defect | Block PR |
| High | 7 | Likely runtime failure, major regression, unsafe concurrency, materially wrong behavior, or missing required test | Fix before PR unless user explicitly accepts and repository policy allows |
| Medium | 4 | Limited defect, maintainability risk, incomplete documentation, or edge-case gap | Prefer fixing; disclose if retained |
| Low | 1 | Minor clarity, style, naming, or non-blocking cleanup | May remain with disclosure |

Report each finding with file/location, evidence, impact, score, and required fix.

### Hard gate

- If any unresolved Critical finding exists, stop before commit, push, and PR creation.
- Leave a concise user-facing review comment listing blockers and fixes.
- Fix Critical findings only when the requested scope authorizes the change, then rerun the entire relevant validation and scoring pass.
- Proceed only when unresolved Critical count is zero. Never lower a severity merely to pass the gate.

## 6. Commit cleanly

- Stage only scoped files and review the staged diff.
- Split unrelated concerns into atomic commits when it improves reviewability.
- Use the repository's convention; otherwise use Conventional Commits.
- Do not add AI attribution or `Co-authored-by` unless requested.
- Recheck status and validations after the final commit.

## 7. Push and open the PR

- Push only the worktree branch and set its upstream.
- Never force-push the target branch. Use `--force-with-lease` on a private feature branch only with explicit authorization.
- Create the PR against the synchronized target branch.
- Include summary, rationale, commit list, validation evidence, severity scorecard, security/privacy result, known limitations, and reviewer focus.
- Do not merge or delete branches unless separately requested.

## 8. Clean current-task duplicates

After push and remote-SHA verification, inspect the primary worktree again.

- A `/pr` request authorizes cleanup only for exact primary-worktree duplicates that this active task created or transferred and recorded in step 2. It does not authorize cleanup of pre-existing, divergent, unrelated, or ambiguously owned user work.
- Before cleanup, compare every candidate byte-for-byte with the committed branch version, create a recoverable temporary backup, and verify that no unrelated change overlaps the path.
- Restore recorded tracked files to the primary worktree's unchanged `HEAD`; move recorded untracked duplicates to the recovery location. Do not use broad `clean`, `reset`, stash, globs, or unresolved paths.
- Verify the primary worktree is clean after narrow cleanup. If any safety condition fails, preserve the file and report the exact blocker instead of hiding it.

## 9. Verify and report

- Verify the PR URL, base/head branches, remote head SHA, and clean worktree.
- Verify and report the primary worktree status. It should remain clean when changes were authored directly in the isolated worktree or after authorized current-task duplicate cleanup.
- Report unresolved findings by severity, test results, commit hashes, and PR URL.
- PR approval or merge on GitHub does not automatically resume a completed agent turn. Unless the user explicitly requested merge monitoring, state that the local target branch remains at its pre-merge base and needs a later fetch plus explicit `--ff-only` update.
- Keep the worktree until the user asks to clean it up or the workflow explicitly includes approved cleanup.

## 10. Monitor through merge when requested

Only run this phase when the user explicitly asks to monitor through merge.

- Keep the workflow active and record the PR number, base/head refs, and initial head SHA.
- Poll PR state, review decision, and checks at a reasonable interval. Do not approve or merge the PR on the user's behalf unless that action was separately requested.
- If the head SHA changes, inspect the new commits and rerun all validations affected by the changed diff before relying on the previous scorecard.
- If the PR closes without merging, do not update the local target; report the closed state and stop monitoring.
- After merge, fetch the remote and verify the merge commit, primary-worktree status, and target divergence.
- Update the primary target only when it is clean and the relationship is the expected fast-forward. Use explicit `--ff-only`; never hide unrelated work with stash, reset, clean, or a broad restore.
- Verify `<target>...origin/<target>` is `0 0`, the primary worktree is clean, and no recorded current-task duplicate remains. If a safety gate fails, preserve the work and report the exact blocker.
