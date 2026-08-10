package pratice_by_agent

// B16. 핸들러 타입 별칭
// Request -> Response 함수 타입에 Router 별칭을 붙이세요.
// then으로 두 Router를 체이닝하세요. (첫번째 응답 body를 두번째 요청 body로)
data class Request(val body: String)
data class Response(val body: String)

typealias Router = (Request) -> Response

fun Router.then(next: Router): Router {
    return { req -> Response("") } // TODO
}

fun main() {
    val upper: Router = { req -> Response(req.body.uppercase()) }
    val wrap: Router = { req -> Response("<${req.body}>") }
    val chain = upper.then(wrap)
    check(chain(Request("ok")).body == "<OK>")
    println("B16 통과")
}
