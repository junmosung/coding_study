# Kotlin 문법으로 이해하는 JVM 메모리

Kotlin 문법을 외우는 데서 끝내지 않고, 작성한 코드가 JVM에서 어떤 실행 단위와 메모리 관계로 바뀌는지 함께 익히는 트랙입니다. 기존 `docs`와 `practice_*` 문제는 그대로 두고 독립적으로 학습할 수 있게 구성했습니다.

> 이 트랙의 그림은 이해를 위한 **개념 모델**입니다. JVM 명세는 논리적인 런타임 영역과 동작을 정의하지만, 실제 주소·객체 헤더·세대 구성·JIT 최적화 방식까지 고정하지 않습니다.

## 학습 순서

| 단계 | 개념 문서 | 문법과 연결되는 질문 | 문제 |
|---:|---|---|---|
| 1 | [Kotlin에서 JVM까지](./docs/01_KOTLIN_TO_JVM.md) | `fun`, `val`, 클래스는 어떻게 bytecode가 되는가? | M01~M02 |
| 2 | [JVM 런타임 메모리 영역](./docs/02_RUNTIME_DATA_AREAS.md) | 지역 변수·함수 호출·클래스 정보는 어디에 대응하는가? | M03 |
| 3 | [Stack frame과 함수 호출](./docs/03_STACK_FRAMES.md) | 매개변수, 지역 변수, 연산 결과, 재귀 호출은 어떻게 쌓이는가? | M04~M05 |
| 4 | [Heap, 객체와 참조](./docs/04_HEAP_REFERENCES.md) | `val`, `==`, `===`, `copy()`는 메모리 관점에서 무엇이 다른가? | M06~M10 |
| 5 | [객체 수명과 GC](./docs/05_GC_AND_LIFETIME.md) | scope가 끝나는 것과 객체가 회수 가능한 것은 같은가? | M11~M12 |
| 6 | [스레드와 Java Memory Model](./docs/06_THREADS_AND_MEMORY.md) | 스레드별 Stack과 공유 Heap은 왜 race condition을 만드는가? | M13~M15 |

전체 문제 목록과 실행법은 [problems/README.md](./problems/README.md)를 참고합니다.

## 먼저 고칠 오해

| 흔한 표현 | 더 정확한 설명 |
|---|---|
| “지역 변수는 Stack에 저장된다” | JVM frame에는 local variable array가 있습니다. 다만 참조형 지역 변수는 객체 자체가 아니라 참조를 보유하며, JIT가 실제 배치를 최적화할 수 있습니다. |
| “객체는 무조건 물리적 Heap에 있다” | JVM 명세에서 인스턴스와 배열은 Heap에 할당됩니다. 실제 HotSpot은 escape analysis와 scalar replacement 등으로 할당을 제거할 수 있습니다. |
| “scope가 끝나면 객체가 즉시 삭제된다” | GC root에서 더는 도달할 수 없을 때 **회수 가능**해질 뿐, 회수 시점은 보장되지 않습니다. |
| “`val`이면 객체도 불변이다” | `val`은 해당 변수의 재할당을 막습니다. 참조한 객체 내부의 `var`나 mutable collection은 변경될 수 있습니다. |
| “코루틴마다 전용 Stack이 있다” | 일반적인 코루틴은 전용 JVM 스레드 Stack을 갖지 않습니다. 중단 상태는 continuation 객체로 표현될 수 있으며 실제 실행은 dispatcher의 스레드 Stack에서 진행됩니다. |

## 권장 학습 루프

1. 문서의 그림을 보고 코드 실행 전 Stack frame과 Heap 객체를 종이에 그립니다.
2. 문제의 `TODO`를 구현하고 `check`를 통과시킵니다.
3. `==`를 `===`로, `val`을 `var`로, 복사를 alias로 바꾸어 결과를 비교합니다.
4. `javap`로 bytecode를 확인하되 bytecode와 실제 기계어 실행을 동일시하지 않습니다.
5. 마지막에 “어떤 참조가 어떤 객체를 살려 두는가?”를 설명합니다.

## 이미지

- [Kotlin → JVM 실행 파이프라인](./assets/kotlin-jvm-pipeline.svg)
- [JVM 런타임 메모리 영역](./assets/jvm-runtime-areas.svg)
- [함수 호출과 Stack frame](./assets/stack-frame-flow.svg)
- [Heap 참조와 GC 도달 가능성](./assets/heap-reference-gc.svg)

공식 참고: [JVM Specification: Run-Time Data Areas](https://docs.oracle.com/javase/specs/jvms/se17/html/jvms-2.html#jvms-2.5), [JVM Frames](https://docs.oracle.com/javase/specs/jvms/se17/html/jvms-2.html#jvms-2.6), [Kotlin/JVM compilation](https://kotlinlang.org/docs/jvm-get-started.html)
