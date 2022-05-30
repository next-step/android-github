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
    Coroutine.apply {
        implementation(CORE)
        testImplementation(TEST)
    }

    HILT.apply {
        implementation(CORE)
        kapt(COMPILER)
    }

    Test.apply {
        testImplementation(JUNIT5_JUPITER)
        testImplementation(JUNIT5_JUPITER_API)
        testImplementation(TRUTH)
        testImplementation(MOCKK)
    }
}