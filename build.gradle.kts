plugins {
    kotlin("jvm") version "2.3.20"
}

repositories {
    mavenCentral()
}

dependencies {
    // kotlin("jvm") 플러그인이 kotlin-stdlib 은 자동으로 추가합니다.
    // Int, String, println, listOf 같은 기본 요소가 모두 여기에 들어 있습니다.
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
}

kotlin {
    jvmToolchain(17)

    // 이 저장소는 Gradle 기본 규약인 src/main/kotlin 대신
    // 언어별 디렉터리(src/<language>) 구조를 사용합니다.
    sourceSets["main"].kotlin.setSrcDirs(listOf("src/kotlin"))
}
