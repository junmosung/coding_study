# Kotlin 컬렉션 고차 함수 치트시트

> **고차 함수(Higher-Order Function)** = 람다(함수)를 인자로 받아 컬렉션을 처리하는 함수들.
> `.map`, `.filter` 같은 것들.

## 핵심 개념

| 구분 | 설명 | 예시 | 체이닝 |
|------|------|------|:---:|
| **중간 연산 (intermediate)** | 컬렉션/시퀀스를 반환 | `map`, `filter`, `sorted` | ✅ 계속 가능 |
| **종단 연산 (terminal)** | 최종값을 반환 (체인 끝) | `sum`, `toList`, `first` | ❌ 여기서 끝 |

- **List** → 연산 즉시 실행 (eager), 중간 리스트 생김
- **Sequence** → 값 꺼낼 때 실행 (lazy), 필요한 만큼만 처리
  - `listOf(...).asSequence()` 또는 `generateSequence(...)`로 생성

---

## 🔄 변환 (Transform)

```kotlin
list.map { it * 2 }              // 각 요소 변환          [1,2] → [2,4]
list.mapIndexed { i, v -> "$i:$v" }  // 인덱스와 함께
list.flatMap { it.toList() }     // 변환 후 펼치기        [[1,2],[3]] → [1,2,3]
list.mapNotNull { it.toIntOrNull() }  // 변환 + null 제거
```

## 🔍 필터 (Filter)

```kotlin
list.filter { it > 0 }           // 조건 맞는 것만        [1,-2,3] → [1,3]
list.filterNot { it > 0 }        // 조건 안 맞는 것만
list.filterNotNull()             // null 제거
list.take(3)                     // 앞에서 3개
list.drop(2)                     // 앞 2개 버림
list.takeWhile { it < 5 }        // 조건 유지되는 동안만
list.dropWhile { it < 5 }        // 조건 유지되는 동안 버림
list.distinct()                  // 중복 제거
```

## 📊 집계 (Aggregate) — 종단 연산

```kotlin
list.sum()                       // 합계
list.count()                     // 개수
list.count { it > 0 }            // 조건 맞는 개수
list.average()                   // 평균
list.max() / list.min()          // 최대 / 최소
list.maxByOrNull { it.age }      // 특정 기준 최대 객체
list.maxOfOrNull { it.age }      // 특정 기준 최댓값
list.reduce { acc, x -> acc + x }     // 누적 (초기값 없음)
list.fold(0) { acc, x -> acc + x }    // 누적 (초기값 있음)
list.sumOf { it.price }          // 특정 값의 합
```

## 🎯 검색 / 판별 (Search) — 종단 연산

```kotlin
list.first() / list.firstOrNull()    // 첫 요소
list.last() / list.lastOrNull()      // 마지막 요소
list.find { it > 3 }             // 조건 맞는 첫 요소
list.any { it > 0 }              // 하나라도 맞나? → Boolean
list.all { it > 0 }              // 전부 맞나? → Boolean
list.none { it > 0 }             // 하나도 없나? → Boolean
list.contains(5)                 // 포함되나?
```

## 🔁 순회 (Iterate) — 종단 연산

```kotlin
list.forEach { println(it) }     // 각 요소로 작업
list.forEachIndexed { i, v -> println("$i: $v") }
```

## 📦 그룹 / 분류 (Group)

```kotlin
list.groupBy { it.age }          // 기준별 묶기 → Map<K, List<V>>
list.partition { it > 0 }        // 두 그룹 (참/거짓) → Pair<List, List>
list.associateBy { it.id }       // id를 키로 → Map<K, V>
list.associate { it.id to it.name }   // 키-값 직접 지정
list.chunked(3)                  // 3개씩 덩어리 → List<List>
list.windowed(3)                 // 3개씩 슬라이딩 윈도우
```

## 🔃 정렬 (Sort)

```kotlin
list.sorted()                    // 오름차순
list.sortedDescending()          // 내림차순
list.sortedBy { it.age }         // 특정 기준 오름차순
list.sortedByDescending { it.age }    // 특정 기준 내림차순
list.reversed()                  // 뒤집기
```

## 📥 수집 / 변환-종단 (Collect) — 종단 연산

```kotlin
list.toList()                    // List로
list.toSet()                     // Set으로 (중복 제거)
list.toMutableList()             // 수정 가능 List로
list.toMap()                     // Pair 리스트 → Map
list.joinToString(", ")          // 문자열로 합치기
list.joinToString(", ", "[", "]") { it.name }  // 구분자/접두/접미/변환
```

---

## 조합 예시

```kotlin
data class User(val name: String, val age: Int)

val users = listOf(User("Kim", 20), User("Lee", 30), User("Park", 25))

// 25세 이상을 나이순 정렬해 이름만 뽑아 문자열로
val result = users
    .filter { it.age >= 25 }         // 골라내기 (중간)
    .sortedBy { it.age }             // 정렬 (중간)
    .map { it.name }                 // 변환 (중간)
    .joinToString(", ")             // 문자열로 (종단)
// "Park, Lee"
```

## 입력 파싱 예시 (Sequence)

```kotlin
// 표준 입력을 EOF까지 한 줄씩 → 객체로 파싱
val students = generateSequence(::readlnOrNull)   // 지연: 한 줄씩
    .filter { it.isNotBlank() }
    .map { line ->
        val (name, score) = line.trim().split(Regex("\\s+"))
        name to score.toInt()
    }
    .toList()                        // 종단: 여기서 실제 실행
```

---

## fold vs reduce

```kotlin
// reduce: 첫 요소가 초기 누적값 (빈 리스트면 예외)
listOf(1, 2, 3).reduce { acc, x -> acc + x }      // 6

// fold: 초기값을 직접 지정 (빈 리스트도 안전, 타입 변경 가능)
listOf(1, 2, 3).fold(10) { acc, x -> acc + x }    // 16
listOf(1, 2, 3).fold("") { acc, x -> "$acc$x" }   // "123" (String으로!)
```

## null 안전 함수 (뒤에 OrNull이 붙으면 예외 대신 null)

| 예외 던짐 | null 반환 |
|-----------|-----------|
| `first()` | `firstOrNull()` |
| `max()` | `maxOrNull()` |
| `single()` | `singleOrNull()` |
| `"abc".toInt()` | `"abc".toIntOrNull()` |

---

## Java Stream 대응 (참고)

| Kotlin | Java Stream |
|--------|-------------|
| `.map { }` | `.map(...)` |
| `.filter { }` | `.filter(...)` |
| `.forEach { }` | `.forEach(...)` |
| `.toList()` | `.collect(Collectors.toList())` / `.toList()` |
| `.sortedBy { }` | `.sorted(Comparator.comparing(...))` |
| `.groupBy { }` | `.collect(Collectors.groupingBy(...))` |
| `.asSequence()` | `.stream()` |
| `.sum()` | `.mapToInt(...).sum()` |
