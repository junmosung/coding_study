package practice_by_claude

// ─────────────────────────────────────────────
// 코틀린 입문 연습 5회차: 널 안전성 (Null Safety)
// 핵심: 코틀린은 null 이 될 수 있는 타입과 없는 타입을 구분합니다!
//   String  → 절대 null 불가
//   String? → null 일 수도 있음 (? 가 붙음)
// 도구 정리:
//   ?.  안전 호출: null 이면 통째로 null 반환
//   ?:  엘비스 연산자: 왼쪽이 null 이면 오른쪽 기본값 사용
//   !!  단언: "절대 null 아님!" (null 이면 앱 크래시 — 가급적 금지)
// ─────────────────────────────────────────────

// [문제 1] 안전 호출 ?. 와 엘비스 ?:
// 닉네임(String?)을 받아 글자 수를 돌려주는 함수.
// null 이면 0 을 돌려주세요.
// 예: nickLength("kotlin") → 6, nickLength(null) → 0
// 힌트: name?.length 는 name 이 null 이면 null 이 됩니다.
//       거기에 ?: 로 기본값을 붙여보세요. 한 줄로 가능!
fun nickLength(nick: String?) = nick?.length ?: 0

// [문제 2] 엘비스로 기본값 넣기
// 닉네임(String?)을 받아 인사말을 돌려주는 함수.
// null 이면 "손님" 으로 대체하세요.
// 예: greet("kotlin") → "안녕하세요, kotlin님!"
//     greet(null)     → "안녕하세요, 손님님!"  (님이 두 번인 건 무시하세요 😄)
// 힌트: val who = nick ?: "손님"
fun greet(nick: String?): String {
    return "안녕하세요, ${nick?:"손"}님!" // TODO
}

// [문제 3] if 로 null 검사 (스마트 캐스트)
// 문자열(String?)을 받아서:
//   - null 이면 "입력 없음"
//   - 빈 문자열("")이면 "빈 문자열"
//   - 그 외엔 "첫 글자: X" 형태로 돌려주세요.
// 예: firstChar("kotlin") → "첫 글자: k"
// 힌트: if (s == null) 검사를 통과한 뒤에는
//       s 를 String? 가 아니라 String 처럼 쓸 수 있어요 (스마트 캐스트!)
//       첫 글자는 s.first() 또는 s[0]
fun firstChar(s: String?): String {
    return if (s == null) {
        "입력 없음"
    } else if (s.isEmpty()) {
        "빈 문자열"
    } else {
        "첫 글자: ${s.first()}"
    }
}

// [문제 4] 리스트 속 null 다루기
// null 이 섞인 정수 리스트에서 null 을 뺀 합계를 구하세요.
// 예: sumNotNull(listOf(1, null, 3, null, 5)) → 9
// 힌트: 방법1 - for 문 안에서 if (n != null) total += n
//       방법2 - list.filterNotNull().sum()  ← null 제거 후 합산 (한 줄!)
fun sumNotNull(numbers: List<Int?>): Int {
    var sum = 0

    for (number in numbers) {
        if (number != null) {
            sum += number
        }
    }
    return sum
}

fun main() {
    println("nickLength(\"kotlin\") = ${nickLength("kotlin")}")  // 기대: 6
    println("nickLength(null) = ${nickLength(null)}")            // 기대: 0

    println(greet("kotlin"))   // 기대: 안녕하세요, kotlin님!
    println(greet(null))       // 기대: 안녕하세요, 손님님!

    println(firstChar("kotlin"))  // 기대: 첫 글자: k
    println(firstChar(""))        // 기대: 빈 문자열
    println(firstChar(null))      // 기대: 입력 없음

    println("sumNotNull = ${sumNotNull(listOf(1, null, 3, null, 5))}")  // 기대: 9
}
