plugins {
    id("java-library")
    id("kotlin")
    id("kotlin-kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.test {
    useJUnitPlatform()
}

dependencies {
    implementation(project(":domain"))

    Coroutine.apply {
        implementation(CORE)
        implementation(TEST)
    }

    Network.apply {
        implementation(RETROFIT)
        implementation(CONVERTER_GSON)
        implementation(OKHTTP)
        testImplementation(MOCK_WEB_SERVER)
    }

    Test.apply {
        testImplementation(JUNIT5_JUPITER)
        testImplementation(TRUTH)
        testImplementation(MOCKK)

        testRuntimeOnly(JUNIT5_VINTAGE_ENGINE)
    }
}
