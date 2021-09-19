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
    implementation(Coroutine.core)
    implementation(OkHttp.core)
    implementation(Retrofit.core)
    implementation(Retrofit.gsonConverter)

    implementation(Hilt.core)
    kapt(Hilt.compiler)

    testImplementation(Test.junit5)
    testImplementation(Test.truth)
    testImplementation(Test.mockk)
    testImplementation(OkHttp.mockWebServer)
    testImplementation(Coroutine.test)
}
