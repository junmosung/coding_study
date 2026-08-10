# JVM 메모리 학습 문제 M01~M15

문법 결과만 맞히지 않고, 구현 후 Stack frame과 Heap 참조 그래프를 설명하는 문제입니다. 각 파일은 독립 실행합니다.

## 실행법

```bash
kotlinc A_기본/M01ValueCopy.kt -include-runtime -d /tmp/m01.jar
java -jar /tmp/m01.jar
```

`check`가 모두 통과하면 성공 메시지가 출력됩니다. 정답 구현은 포함하지 않았으며 각 파일의 `TODO`를 채웁니다.

## A · 기본 — 값, 호출, frame

| 문제 | 학습 목표 | 구현 후 설명할 것 |
|---|---|---|
| [M01 값 복사](./A_기본/M01ValueCopy.kt) | primitive 값 전달 | caller와 callee의 `Int` local slot 관계 |
| [M02 객체 반환](./A_기본/M02ReturnedReference.kt) | 함수 종료 후 객체 수명 | frame이 pop된 후 Box가 살아 있는 이유 |
| [M03 호출 추적](./A_기본/M03CallFrames.kt) | 중첩 호출의 push/pop | 어느 시점에 어떤 frame이 current인가 |
| [M04 재귀 합계](./A_기본/M04TailRecSum.kt) | 재귀와 `tailrec` | 일반 재귀와 반복 변환의 Stack 차이 |
| [M05 참조 값 전달](./A_기본/M05ReferenceParameter.kt) | 참조도 값으로 전달 | 재할당과 객체 변경의 차이 |

## B · 참조와 객체 — Heap graph

| 문제 | 학습 목표 | 구현 후 설명할 것 |
|---|---|---|
| [M06 Alias 분리](./B_참조와객체/M06AliasIsolation.kt) | 같은 객체를 가리키는 두 참조 | 왜 원본까지 변경되는가 |
| [M07 Equality](./B_참조와객체/M07Equality.kt) | `==`와 `===` | 구조 동등성과 참조 동일성 |
| [M08 깊은 복사](./B_참조와객체/M08DeepCopy.kt) | data class의 얕은 `copy` | 중첩 mutable list를 분리하는 법 |
| [M09 도달 가능 객체](./B_참조와객체/M09Reachability.kt) | root 기반 graph 탐색 | 순환 참조만으로 객체가 살아남지 않는 이유 |
| [M10 불변 상태 교체](./B_참조와객체/M10ImmutableUpdate.kt) | 변경 대신 새 graph 생성 | 원본과 새 객체가 공유해도 안전한 부분 |

## C · GC와 동시성 — 수명과 공유 상태

| 문제 | 학습 목표 | 구현 후 설명할 것 |
|---|---|---|
| [M11 제한 Cache](./C_GC와동시성/M11BoundedCache.kt) | 장수 root의 참조 제한 | 무제한 Map이 객체를 살려 두는 이유 |
| [M12 참조 끊기](./C_GC와동시성/M12DetachGraph.kt) | graph edge 제거 | `null` 대입이 삭제가 아닌 이유 |
| [M13 스레드별 local](./C_GC와동시성/M13ThreadLocalFrames.kt) | thread별 Stack frame | local 합계를 공유하지 않아도 되는 이유 |
| [M14 원자 Counter](./C_GC와동시성/M14AtomicCounter.kt) | 공유 Heap field 경쟁 | `volatile`과 atomic increment 차이 |
| [M15 worker 결과 전달](./C_GC와동시성/M15WorkerPublication.kt) | `start`/`join` happens-before | join 이후 결과를 읽을 수 있는 이유 |

## 완료 체크

- [ ] source 변수, frame local slot, Heap 객체를 구분해 그림으로 그릴 수 있다.
- [ ] parameter 전달을 “참조 전달”이 아닌 “참조 값의 복사”로 설명할 수 있다.
- [ ] `copy()`가 깊은 복사가 아닌 예를 만들 수 있다.
- [ ] GC root에서 도달 가능성을 탐색할 수 있다.
- [ ] thread별 Stack과 공유 Heap이 race condition으로 이어지는 과정을 설명할 수 있다.
