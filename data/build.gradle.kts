plugins {
    id("java-library")
    kotlin("jvm")
    kotlin("kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(project(":domain"))

    Coroutine.apply {
        implementation(CORE)
        testImplementation(TEST)
    }

    Network.apply {
        implementation(RETROFIT)
        implementation(CONVERTER_GSON)
        implementation(OKHTTP)
        testImplementation(MOCK_WEB_SERVER)
    }
    HILT.apply {
        implementation(CORE)
        kapt(COMPILER)
    }

    Test.apply {
        testImplementation(JUNIT5_JUPITER_API)
        testRuntimeOnly(JUNIT5_JUPITER_ENGINE)
        testImplementation(JUNIT5_JUPITER_PARAMS)
        testRuntimeOnly(JUNIT5_VINTAGE_ENGINE)
        testImplementation(TRUTH)
        testImplementation(MOCKK)
    }
}