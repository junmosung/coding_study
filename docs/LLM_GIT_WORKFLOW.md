# LLM 공통 Git·Commit·Push·PR 전략

이 문서는 Codex, Claude Code 및 다른 코딩 에이전트가 함께 사용하는 단일 Git 작업 원칙입니다. 도구별 로컬 설정이 아니라 저장소에 적용되는 규칙만 기록합니다.

## 1. 기본 원칙

- `main`은 항상 컴파일 또는 실행 가능한 상태로 유지합니다.
- 일반 변경은 브랜치에서 작업하고 Pull Request로 `main`에 병합합니다.
- 한 브랜치는 하나의 목적만 다룹니다.
- 다른 사용자나 에이전트가 만든 미완료 변경을 임의로 포함하거나 되돌리지 않습니다.
- 커밋과 푸시, PR 생성은 사용자가 명시적으로 요청했을 때만 수행합니다.

## 2. 브랜치 이름

`<type>/<short-description>` 형식을 사용합니다.

| 유형 | 용도 | 예시 |
|---|---|---|
| `feat` | 새 문제, 새 문서, 새 기능 | `feat/kotlin-practical-exercises` |
| `fix` | 오류 수정 | `fix/broken-readme-links` |
| `docs` | 문서만 변경 | `docs/llm-git-workflow` |
| `refactor` | 동작을 유지한 구조 변경 | `refactor/kotlin-directory-layout` |
| `chore` | 설정과 유지보수 | `chore/update-gitignore` |

브랜치명은 영문 소문자와 하이픈을 사용합니다. 개인 이름이나 LLM 이름보다 변경 목적을 우선합니다.

## 3. 작업 시작

```bash
git status --short --branch
git fetch origin
git switch main
git pull --ff-only origin main
git switch -c feat/short-description
```

작업 트리가 깨끗하지 않다면 기존 변경의 소유자와 목적부터 확인합니다. 임의로 `reset`, `checkout`, `clean`, stash를 실행하지 않습니다.

### Fast-forward 및 worktree 재발 방지

- 대상 브랜치 동기화에는 항상 명령 자체에 `--ff-only`를 지정합니다. 사용자 전역 설정은 환경마다 다르므로 안전 정책으로 간주하지 않습니다.
- `git merge origin/main`이나 옵션 없는 `git pull`은 동기화 명령으로 사용하지 않습니다. 전역 `merge.ff=false`가 설정된 환경에서는 fast-forward 가능한 관계에도 불필요한 merge commit이 생길 수 있습니다.
- 동기화 전후에 `git rev-list --left-right --count main...origin/main`을 실행해 divergence가 예상과 일치하는지 확인합니다.
- 저장소별 기본 안전 설정이 필요하면 다음을 사용할 수 있습니다.

```bash
git config --local merge.ff only
git config --local pull.ff only
```

- PR 변경은 가능하면 처음부터 격리 worktree에서 작성합니다. primary worktree에서 현재 작업이 만든 변경을 옮겨야 한다면 정확한 경로를 기록합니다. 복사한 미추적 파일이나 수정 파일은 원본 작업공간에서 자동으로 사라지지 않습니다.
- `/pr` 요청은 **현재 PR 작업이 primary worktree에 새로 만든 중복본**을 원격 브랜치에 보존한 뒤 안전하게 정리하는 범위까지 포함합니다. 정리 전에는 커밋본과 byte 단위 동일성, 임시 복구 사본, 해당 경로에 무관한 사용자 변경이 없음을 모두 확인합니다. 기존부터 있던 변경, 내용이 다른 변경, 소유권이 불분명한 변경은 정리하지 않고 구체적인 차단 사유를 보고합니다.
- PR을 열고 작업이 종료되면 GitHub의 승인·병합 이벤트가 에이전트 작업을 자동으로 재개하지 않습니다. 사용자가 병합 감시를 함께 요청하지 않았다면 완료 보고에 이 한계와 병합 후 로컬 `main`을 `--ff-only`로 갱신해야 한다는 사실을 명시합니다.
- 사용자가 병합까지 감시해 달라고 요청한 경우에만 작업을 유지하며 PR 상태를 확인합니다. 병합 확인 뒤 primary worktree가 깨끗하고 예상하지 않은 divergence가 없을 때 `git fetch origin`과 명시적 fast-forward를 수행하고 `main...origin/main`이 `0 0`인지 검증합니다.

## 4. 커밋 전 점검

최소한 다음 항목을 확인합니다.

```bash
git status --short
git diff
git diff --check
```

Kotlin 변경은 가능한 경우 전체 소스를 컴파일합니다.

```bash
find src/kotlin -name '*.kt' -print0 | xargs -0 kotlinc -d /tmp/coding-study-kotlin.jar
```

추가 확인 사항:

- 실제 개인정보, 로컬 절대경로, API 키, 토큰, 개인 이메일이 없는가
- `.env`, 키 파일, `.idea/`, `.codex/`, `.claude/`가 추적되지 않는가
- README 링크와 패키지 경로가 맞는가
- 문제용 `TODO`와 검증 코드가 의도대로 남아 있는가

## 5. 커밋 전략

작고 독립적으로 검토 가능한 단위로 커밋합니다. Conventional Commits 형태를 기본으로 사용합니다.

```text
<type>(optional-scope): <imperative summary>
```

예시:

```text
feat(kotlin): add practical grammar exercises
docs: document shared LLM workflow
fix(kotlin): correct broken exercise links
refactor: organize sources by language
chore: extend public repository ignores
```

커밋 규칙:

- 제목은 한 가지 변경을 설명하고 72자 안팎으로 간결하게 작성합니다.
- 생성형 AI가 작성했다는 문구나 `Co-authored-by`는 사용자가 요청할 때만 추가합니다.
- 포맷 수정과 기능 변경이 크다면 커밋을 분리합니다.
- 검증 결과와 중요한 판단은 필요할 때 커밋 본문에 기록합니다.
- 민감정보를 발견하면 커밋하지 말고 먼저 제거한 뒤 노출 가능성을 알립니다.

## 6. Push 전략

```bash
git push -u origin feat/short-description
```

- 현재 작업 브랜치만 푸시합니다.
- `main`에 직접 푸시하지 않습니다.
- 공유 브랜치와 `main`에는 force push를 사용하지 않습니다.
- 개인 작업 브랜치의 이력 정리가 꼭 필요한 경우에도 사용자 승인 후 `--force-with-lease`만 고려합니다.
- 푸시 후 원격 브랜치가 로컬 HEAD와 같은 커밋인지 확인합니다.

## 7. Pull Request 전략

PR은 작고 하나의 목적에 집중해야 합니다. 제목은 커밋 제목과 같은 형식을 권장합니다.

본문에는 다음을 작성합니다.

1. 무엇을 변경했는지
2. 왜 변경했는지
3. 어떻게 검증했는지
4. 공개 저장소 안전 점검 결과
5. 리뷰어가 특히 볼 부분과 남은 작업

Draft PR은 설계 피드백이나 중간 공유가 필요할 때 사용합니다. 병합 가능한 상태에서는 다음 조건을 충족합니다.

- 관련 검증 통과
- 의도하지 않은 파일 변경 없음
- 충돌 없음
- 문서와 코드 일치
- 민감정보 없음

## 8. 리뷰와 병합

- 리뷰 의견은 별도의 작은 커밋으로 반영해 검토 흐름을 보존할 수 있습니다.
- PR 완료 후에는 저장소가 정한 병합 방식을 따릅니다. 별도 규칙이 없다면 학습 저장소의 단순한 이력을 위해 squash merge를 권장합니다.
- 병합 후 원격 브랜치를 삭제하고 로컬 `main`을 `--ff-only`로 갱신합니다.
- 갱신 후 `git rev-list --left-right --count main...origin/main`이 `0 0`인지, primary worktree에 PR로 옮긴 파일의 미추적 복제본이 남지 않았는지 확인합니다.
- 에이전트는 사용자 승인 없이 PR 병합이나 브랜치 삭제를 수행하지 않습니다.

### PR 생성과 병합 후 동기화의 경계

| 시점 | 에이전트가 수행할 일 | primary `main` 상태 |
|---|---|---|
| PR 생성 전 | 격리 worktree에서 작성·검증·커밋 | 변경하지 않음 |
| PR push 직후 | 원격 SHA 확인, 현재 작업이 만든 primary 중복본만 안전 조건 충족 시 정리 | 깨끗하게 유지 |
| 외부 승인·병합 | 별도 감시 요청이 없으면 자동 실행 없음 | PR 생성 당시 커밋에 머물 수 있음 |
| 병합 감시 요청 시 | 병합 확인 후 fetch 및 `--ff-only` 동기화 | `origin/main`과 `0 0` 확인 |

### 병합 감시 실행 체크리스트

사용자가 “병합까지 감시”를 명시하면 다음 순서로 같은 작업을 유지합니다.

1. PR 번호, base/head 브랜치, 감시 시작 시점의 head SHA를 기록합니다.
2. PR이 열려 있는 동안 상태·승인·검사 결과를 주기적으로 확인하되 에이전트가 직접 승인하거나 병합하지 않습니다.
3. 감시 중 head SHA가 바뀌면 새 커밋의 diff와 필수 검증을 다시 확인합니다. 검증하지 않은 변경을 기존 결과로 통과 처리하지 않습니다.
4. PR이 병합 없이 닫히면 로컬 브랜치를 갱신하지 않고 종료 사유를 보고합니다.
5. 병합되면 merge commit과 `origin/main`을 fetch한 뒤 primary worktree의 상태와 divergence를 다시 확인합니다.
6. primary가 깨끗하고 예상한 fast-forward 관계일 때만 `git merge --ff-only origin/main`을 실행합니다. 무관한 변경이나 충돌 가능성이 있으면 보존하고 차단 경로를 구체적으로 보고합니다.
7. 마지막으로 `main...origin/main`이 `0 0`이고 primary에 현재 작업의 중복본이 없는지 확인합니다.

## 9. `main` 직접 Push 예외

저장소 초기 설정, 사용자가 명시한 단순 관리 작업 등 PR이 불필요하다고 사용자가 분명히 결정한 경우에만 허용합니다. 이때도 다음 순서를 지킵니다.

1. 변경 범위와 작업 트리 확인
2. 컴파일·링크·민감정보 검사
3. 원자적 커밋 생성
4. `git push origin main`
5. 원격 커밋 해시 및 clean 상태 확인

## 10. 도구별 파일 역할

| 파일/경로 | Git 추적 | 역할 |
|---|---:|---|
| `AGENTS.md` | 예 | Codex 및 AGENTS 표준 지원 에이전트의 공통 진입점 |
| `CLAUDE.md` | 예 | Claude Code 진입점이며 공통 지침을 import |
| `docs/LLM_GIT_WORKFLOW.md` | 예 | 모든 LLM이 공유하는 단일 Git/PR 정책 원본 |
| `skills/pr/SKILL.md` | 예 | `/pr` 실행 시 사용하는 검증·점수화·차단 절차 |
| `.codex/` | 아니오 | 개인 Codex 설정 |
| `.claude/` | 아니오 | 개인 Claude 설정 |
| `.agents/` | 아니오 | 개인 에이전트 실행 상태 및 설정 |
| `CLAUDE.local.md` | 아니오 | 저장소에 공유하지 않는 Claude 개인 지침 |

공통 정책을 변경할 때는 이 문서를 먼저 수정합니다. `/pr`의 실행 순서나 차단 기준을 바꿀 때는 `skills/pr/SKILL.md`도 함께 갱신하고 개인 Codex 설치본과 동기화합니다. 도구별 진입 파일에는 같은 규칙을 복사해 두지 않아 문서 간 불일치를 방지합니다.
