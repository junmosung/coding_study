# Kotlin 문법·심화 문서 목록

Kotlin을 주 언어로 사용할 때 자주 판단해야 하는 문법과 관용구를 주제별로 정리합니다. 순서대로 읽되, 문제를 풀다가 막힌 주제의 문서를 참고 자료로 사용합니다.

| 순서 | 문서 | 핵심 질문 |
|---:|---|---|
| 1 | [기본 문법](./01_BASIC_SYNTAX.md) | Kotlin의 표현식 중심 문법은 Java와 어떻게 다른가? |
| 2 | [Null 안전성](./02_NULL_SAFETY.md) | 값 부재를 타입으로 어떻게 안전하게 표현하는가? |
| 3 | [함수와 람다](./03_FUNCTIONS_LAMBDAS.md) | 함수를 값으로 전달하고 API를 어떻게 간결하게 만드는가? |
| 4 | [타입 모델링](./04_TYPE_MODELING.md) | data·enum·sealed·value class를 언제 선택하는가? |
| 5 | [컬렉션과 Sequence](./05_COLLECTIONS_SEQUENCES.md) | 변환 파이프라인과 실행 시점을 어떻게 선택하는가? |
| 6 | [제네릭과 변성](./06_GENERICS_VARIANCE.md) | `in`, `out`, 타입 제약은 왜 필요한가? |
| 7 | [확장·스코프 함수·위임](./07_EXTENSIONS_SCOPE_DELEGATION.md) | 편의 문법을 어디까지 사용해야 읽기 좋은가? |
| 8 | [오류 처리와 Result](./08_ERRORS_RESULT.md) | nullable, 예외, Result를 각각 언제 선택하는가? |
| 9 | [코루틴 기초](./09_COROUTINES.md) | `suspend`와 `runBlocking`은 무엇이고, 중단과 블로킹은 어떻게 다른가? |
| 10 | [Java 상호 운용](./10_JAVA_INTEROP.md) | JVM 생태계와 섞일 때 무엇을 조심해야 하는가? |
| 11 | [관용구와 스타일](./11_IDIOMS_STYLE.md) | 동작하는 코드를 Kotlin다운 코드로 어떻게 다듬는가? |
| 12 | [JVM 스레드와 동시성](./12_THREADS_CONCURRENCY.md) | 공유 상태와 스레드 생명주기를 어떻게 안전하게 관리하는가? |
| 13 | [코루틴 심화](./13_COROUTINES_ADVANCED.md) | 취소·실패 전파·Dispatcher를 어떻게 설계하는가? |

## 심화 학습

기본 문법을 익힌 뒤에는 “문법을 아는 것”에서 “실행 모델과 실패 조건을 설명할 수 있는 것”으로 학습 목표를 확장합니다.

| 순서 | 문서 | 핵심 질문 | 시각 자료 |
|---:|---|---|---|
| 9 | [코루틴 기초](./09_COROUTINES.md) | `suspend` / `runBlocking`과 중단·블로킹 차이 | sleep vs delay, runBlocking 흐름 |
| 12 | [JVM 스레드와 동시성](./12_THREADS_CONCURRENCY.md) | main과 worker는 어떻게 분기·합류하며 공유 상태를 어떻게 보호하는가? | main/worker 흐름, 스레드 생명주기 |
| 13 | [코루틴 심화](./13_COROUTINES_ADVANCED.md) | 중단·재개, dispatcher, 취소와 실패 전파는 어떻게 연결되는가? | 코루틴 스레드 전환 |

이미지 원본은 [`assets`](./assets/)에 SVG로 관리합니다. 확대해도 선명하고, 브라우저와 GitHub의 Markdown에서 바로 확인할 수 있습니다.

컬렉션 함수별 빠른 검색은 [KOTLIN_CHEATSHEET.md](../KOTLIN_CHEATSHEET.md)를 함께 참고합니다.

문법을 JVM Stack·Heap·GC·스레드 메모리와 연결해 공부하려면 별도 트랙인 [Kotlin 문법으로 이해하는 JVM 메모리](../jvm_memory_learning/README.md)를 이어서 학습합니다. 기존 문법 문제와 독립되어 있어 순서대로 병행할 수 있습니다.

## 권장 사용법

1. 예제를 직접 입력하고 반환 타입을 예상합니다.
2. 예제의 `val`을 `var`로, nullable을 non-null로 바꾸며 컴파일러 반응을 확인합니다.
3. 같은 기능을 반복문과 컬렉션 함수로 각각 구현해 가독성을 비교합니다.
4. 문법 이름보다 “언제 선택하면 좋은가”를 자신의 말로 설명합니다.
5. 심화 문서의 흐름도를 보고 실행 순서, 대기 지점, 실패·취소 전파를 직접 그려 봅니다.
