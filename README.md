# Kotlin Coding Study

Kotlin을 주 언어로 익히기 위한 문법 연습 및 실험 코드 저장소입니다.

## 구성

| 경로 | 내용 |
|---|---|
| `src/practice_by_claude` | Claude와 진행한 Kotlin 입문 연습 |
| `src/pratice_by_agent` | Agent가 구성한 기본·심화 문법 문제 |
| `src/pratice_by_codex` | Codex가 구성한 기본·실전 문법 문제 |
| `KOTLIN_CHEATSHEET.md` | Kotlin 컬렉션 고차 함수 요약 |

각 연습 문제는 파일 안의 `TODO`를 직접 구현하고 `main`의 출력 또는 `check(...)`로 결과를 확인하는 방식입니다.

## 실행

IntelliJ IDEA에서 원하는 `.kt` 파일의 `main` 함수를 실행합니다. Kotlin CLI가 설치되어 있다면 다음처럼 개별 파일을 컴파일할 수도 있습니다.

```bash
kotlinc src/practice_by_claude/Practice01.kt -include-runtime -d practice01.jar
java -jar practice01.jar
```

## 공개 저장소 안전 원칙

IDE 설정, Codex 로컬 설정, 빌드 결과, 환경 변수 파일, 키 및 인증서 파일은 `.gitignore`에서 제외합니다. 예제에는 실제 개인정보나 실제 계정 정보를 사용하지 않습니다.

## 라이선스

[Apache License 2.0](./LICENSE)
