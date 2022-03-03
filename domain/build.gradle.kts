plugins {
    id("kotlin")
    id("kotlin-kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    Coroutines.run {
        implementation(CORE)
    }

    Hilt.run {
        implementation(CORE)
        kapt(COMPILER)
    }

    Test.run {
        testRuntimeOnly(ENGINE)
        testImplementation(JUPITER)
        testImplementation(ASSERTJ)
        testImplementation(MOCKK)
    }
}

tasks.test {
    useJUnitPlatform()
}
