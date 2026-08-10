package practice_by_claude

data class User(val name: String, var email: String) {
    constructor(name: String, age: Int) : this(name, "")
}
