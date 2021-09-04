plugins {
    id("java-library")
    id("kotlin")
    id("kotlin-kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(project(":domain"))

    NetworkConfig.run {
        implementation(RETROFIT)
        implementation(CONVERTER_MOSHI)
    }

    ConverterConfig.run {
        implementation(MOSHI_KOTLIN)
        kapt(MOSHI_KOTLIN_CODEGEN)
    }

    implementation(CoroutinesConfig.CORE)

    implementation(HiltConfig.CORE)

    testImplementation("org.junit.jupiter:junit-jupiter:$junit5Version")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junit5Version")
    testImplementation("org.assertj:assertj-core:3.18.0")
    testImplementation("io.mockk:mockk:1.12.0")
    testImplementation(TestConfig.MOCK_WEB_SERVER)
}

tasks.test {
    useJUnitPlatform()
}
