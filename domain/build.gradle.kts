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

    Test.apply {
        testImplementation(JUNIT5)
        testRuntimeOnly(JUNIT5_VINTAGE_ENGINE) // junit4 지원
        testImplementation(THRUTH)
    }
}
