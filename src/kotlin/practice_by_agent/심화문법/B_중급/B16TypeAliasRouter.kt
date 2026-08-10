package practice_by_agent

// B16. 라우터 별칭
// 목표: Router then 체인. 1응답 body→2요청 body.
// 문법: typealias, 함수 타입
// 규칙: upper then wrap.
// 예: chain(Request("ok")).body=="<OK>"
// 금지: 인터페이스 강제만
// 문서: docs/03_FUNCTIONS_LAMBDAS.md

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
