package practice_by_claude

// ─────────────────────────────────────────────
// 코틀린 입문 연습 6회차: 클래스와 데이터 클래스
// 핵심 문법 미리보기:
//   class Person(val name: String, var age: Int)   ← 생성자+프로퍼티가 한 줄!
//   val p = Person("kotlin", 20)                   ← new 키워드 없음!
//   p.name                                         ← getter 자동 생성
//   data class 는 toString/equals/copy 를 공짜로 줍니다
// ─────────────────────────────────────────────

// [문제 1] 기본 클래스 만들기
// Dog 클래스를 만드세요:
//   - 생성자에서 name(String, 읽기 전용)과 age(Int, 변경 가능)를 받음
//   - bark() 메서드: "멍멍! 나는 name, age살!" 출력
// 예: Dog("초코", 3).bark() → 멍멍! 나는 초코, 3살!
// TODO: 여기에 Dog 클래스를 작성하세요
class Dog(val name: String, var age: Int){

    fun bark() {
        println("멍멍! 나는 $name, ${age}살!")
    }

    fun birthday() {
        age++
        println("${name}는 이제 ${age}살!")
    }
}

// [문제 2] 메서드에서 프로퍼티 변경
// 문제 1의 Dog 에 birthday() 메서드를 추가하세요:
//   - 호출할 때마다 age 를 1 올리고
//   - "name는 이제 age살!" 출력
// 예: choco.birthday() → 초코는 이제 4살!
// 힌트: age 가 var 여야 바꿀 수 있겠죠?


// [문제 3] 데이터 클래스
// User 데이터 클래스를 만드세요: name(String), email(String)
// 그리고 아래 main 의 주석을 해제해서 결과를 관찰하세요.
// 일반 class 와 달리 data class 는:
//   - toString: User(name=kotlin, email=learner@example.com) 처럼 예쁘게 출력
//   - equals: 내용이 같으면 == 가 true
//   - copy: 일부만 바꾼 복사본 생성
// TODO: 여기에 User 데이터 클래스를 작성하세요 (한 줄이면 충분!)


// [문제 4] copy 활용
// User 를 받아 이메일 도메인만 "@kotlin.dev" 로 바꾼 "새" User 를
// 돌려주는 함수를 완성하세요. 원본은 건드리면 안 됩니다!
// 예: migrate(User("kotlin", "learner@example.com")) → User(name=kotlin, email=learner@kotlin.dev)
// 힌트: 아이디는 email.substringBefore("@") 로 꺼낼 수 있어요
//       user.copy(email = ...) 사용!
fun migrate(user: User) = user.copy(user.name, "${user.email.split("@").first()}@kotlin.dev")

fun main() {
    // ── 문제 1, 2 확인 ──
     val choco = Dog("초코", 3)
     choco.bark()        // 기대: 멍멍! 나는 초코, 3살!
     choco.birthday()    // 기대: 초코는 이제 4살!
     choco.bark()        // 기대: 멍멍! 나는 초코, 4살!

    // ── 문제 3 확인 ──
     val u1 = User("kotlin", "learner@example.com")
     val u2 = User("kotlin", "learner@example.com")
     println(u1)             // 기대: User(name=kotlin, email=learner@example.com)
     println(u1 == u2)       // 기대: true  (내용 비교! 자바의 equals 자동 구현)

    // ── 문제 4 확인 ──
     val migrated = migrate(u1)
     println(migrated)       // 기대: User(name=kotlin, email=learner@kotlin.dev)
     println(u1)             // 기대: User(name=kotlin, email=learner@example.com) ← 원본 그대로!
}
