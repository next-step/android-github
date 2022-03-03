plugins {
    id("kotlin")
    id("kotlin-kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(project(":domain"))

    Coroutines.run {
        implementation(CORE)
    }

    Hilt.run {
        implementation(CORE)
        kapt(COMPILER)
    }

    Network.run {
        api(RETROFIT)
        api(CONVERTER_MOSHI)
    }

    Converter.run {
        api(MOSHI_KOTLIN)
        kapt(MOSHI_KOTLIN_CODEGEN)
    }

    Test.run {
        testRuntimeOnly(ENGINE)
        testImplementation(JUPITER)
        testImplementation(ASSERTJ)
        testImplementation(MOCKK)
        testImplementation(MOCK_WEB_SERVER)
    }
}

tasks.test {
    useJUnitPlatform()
}
