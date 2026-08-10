# Repository Agent Guide

이 파일은 Codex와 `AGENTS.md`를 지원하는 모든 코딩 에이전트의 공통 진입점입니다.

## Repository purpose

- 이 저장소는 Kotlin을 시작으로 Java, Python, SQL 학습 자료를 관리합니다.
- 언어별 자료는 `src/<language>` 아래에 둡니다.
- 기존 학습 트랙의 작성 주체를 존중합니다. 별도 요청이 없다면 Codex 작업은 `practice_by_codex` 안에서 진행하고, `practice_by_claude` 및 `practice_by_agent`의 문제 내용은 변경하지 않습니다.

## Working rules

- 변경 전에 현재 작업 트리와 관련 문서를 먼저 확인합니다.
- 사용자가 만든 변경과 무관한 파일은 수정하거나 되돌리지 않습니다.
- 문제 파일에는 구체적인 요구사항, 학습할 문법, `TODO`, 실행 가능한 검증 코드가 있어야 합니다.
- 공개 저장소에 개인정보, API 키, 토큰, 인증서, 로컬 경로 및 IDE/LLM 개인 설정을 커밋하지 않습니다.
- 파일과 문서의 경로 및 링크가 실제 구조와 일치하도록 유지합니다.

## Validation

- Kotlin 파일 변경 후 가능한 범위에서 전체 소스를 컴파일합니다.
- Markdown 링크, `git diff --check`, 비밀정보 패턴, 추적 대상 파일을 확인합니다.
- 검증하지 못한 항목은 완료한 것처럼 표현하지 않습니다.

## Git, commit, push, and pull requests

- Git 상태를 바꾸기 전에 [공통 Git/PR 워크플로](docs/LLM_GIT_WORKFLOW.md)를 읽고 따릅니다.
- 사용자가 `/pr`, `$pr` 또는 PR 생성을 요청하면 [공용 PR 스킬](skills/pr/SKILL.md)을 읽고 Critical 차단 게이트를 적용합니다.
- 대상 브랜치 동기화에는 명령에 `--ff-only`를 직접 지정합니다. 사용자 전역 `merge.ff` 설정을 신뢰하거나 `git merge origin/main`, 옵션 없는 `git pull`로 동기화하지 않습니다.
- PR 변경은 가능하면 처음부터 격리 worktree에서 작성합니다. 현재 작업이 primary worktree에 만든 변경을 옮겼다면 해당 경로를 기록하고, 원격 보존 뒤 byte 단위 동일성·복구 사본·무관한 사용자 변경 부재를 확인한 범위에서만 중복을 정리합니다.
- PR 생성으로 종료된 에이전트 작업은 이후 GitHub 승인·병합 이벤트로 자동 재개되지 않습니다. 병합 감시를 요청받지 않았다면 이 한계와 `main`의 후속 `--ff-only` 동기화 필요성을 완료 보고에 명시합니다.
- 사용자의 명시적인 요청 없이 커밋, 푸시, PR 생성, 브랜치 삭제를 하지 않습니다.
- `main` 직접 푸시는 사용자가 명시적으로 요청한 초기 설정 또는 예외 상황에만 허용합니다.

## Code review rules

- 학습자가 풀어야 할 `TODO`가 실수로 정답 구현으로 대체되지 않았는지 확인합니다.
- 예제 코드가 문서에 적힌 문법과 실제로 대응하는지 확인합니다.
- 공개 저장소 안전 원칙과 작성 주체별 디렉터리 경계를 우선 검토합니다.
