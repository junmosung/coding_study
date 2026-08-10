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

## 8. Verify and report

- Verify the PR URL, base/head branches, remote head SHA, and clean worktree.
- Report unresolved findings by severity, test results, commit hashes, and PR URL.
- Keep the worktree until the user asks to clean it up or the workflow explicitly includes approved cleanup.
