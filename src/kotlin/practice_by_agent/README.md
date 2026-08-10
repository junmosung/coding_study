# practice_by_agent

드론 물류·관제 시나리오로 Kotlin을 익히는 Agent 연습 트랙입니다.
이론 문서([`../docs`](../docs/README.md))와 짝을 이루며, 각 `.kt`의 `TODO`를 채운 뒤 `check(...)`로 검증합니다.

## 빠른 시작

1. [중요 문법 맵](./GRAMMAR_MAP.md)에서 ★★★ 항목을 확인합니다.
2. [기본 문법](./기본문법/README.md) A01부터 순서대로 풉니다.
3. 막히면 해당 문법의 `docs/0x_*.md`를 읽고 다시 시도합니다.
4. 기본 문법 완료 후 [심화 문법](./심화문법/README.md) B01로 진행합니다.

힌트/채점: `A01 힌트만 줘` / `A01 채점해줘. 정답은 바로 보여주지 마`

## 트랙 한눈에

| 순서 | 트랙 | 문제 | 핵심 목표 |
|---:|---|---|---|
| 1 | [기본 문법](./기본문법/README.md) | A01~A36 | 표현식·null·컬렉션·타입 모델링·Thread 기초 |
| 2 | [심화 문법](./심화문법/README.md) | B01~B28 | Result·제네릭 변성·DSL·Executor/Atomic |

| 비교 | Agent | Codex |
|---|---|---|
| 테마 | 드론 물류 / 관제탑 | 우주 탐사 |
| 기본 트랙 | A01~A36 (Thread 포함) | C01~C30 |
| 다음 트랙 | 심화 B01~B28 (JVM 동시성) | 실전 C31~C60 (API·DSL, 코루틴 제외) |

## 디렉터리

```text
practice_by_agent/
├── README.md
├── GRAMMAR_MAP.md          ← 문법 ↔ 문제 인덱스
├── 기본문법/
│   ├── A_기본/   A01~A10   값·조건·반복
│   ├── B_중급/   A11~A20   null·컬렉션
│   ├── C_고급/   A21~A28   클래스·sealed·제네릭
│   └── D_최고급/ A29~A36   고차함수·Sequence·Thread
└── 심화문법/
    ├── A_기본/   B01~B08   require·Result·빌더·집계
    ├── B_중급/   B09~B16   inline·변성·위임
    ├── C_고급/   B17~B22   operator·DSL
    └── D_최고급/ B23~B28   Executor·Atomic·종합
```

## 문제 파일 규칙

각 `.kt` 상단 주석에 **목표 / 문법 / 규칙 / 예 / 금지**를 둡니다.
패키지는 `practice_by_agent`로 통일합니다.
