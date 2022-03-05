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
    Kotlin.apply {
        implementation(STDLIB)
    }

    Coroutines.apply {
        implementation(CORE)
        implementation(TEST)
    }

    Hilt.apply {
        implementation(CORE)
        kapt(COMPILER)
    }

    Test.apply {
        testImplementation(JUNIT5_JUPITER_API)
        testImplementation(JUNIT5_JUPITER_PARAMS)
        testRuntimeOnly(JUNIT5_VINTAGE_ENGINE) // junit4 지원
        testImplementation(TRUTH)
    }
}
