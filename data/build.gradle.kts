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

    Retrofit.run {
        implementation(retrofit)
        implementation(gsonConverter)
    }

    OkHttp.run {
        implementation(core)
        implementation(loggingInterceptor)
    }

    ConverterConfig.run {
        implementation(moshiKotlin)
        kapt(moshiKotlinCodeGen)
    }

    implementation(CoroutinesConfig.core)

    testImplementation("org.junit.jupiter:junit-jupiter:$junit5Version")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junit5Version")
    testImplementation("org.assertj:assertj-core:3.18.0")
    testImplementation("io.mockk:mockk:1.12.0")
    testImplementation(TestConfig.mockWebServer)
}

tasks.test {
    useJUnitPlatform()
}