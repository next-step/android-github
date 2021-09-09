plugins {
    id("java-library")
    id("kotlin")
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
    implementation(Retrofit.core)
    implementation(Retrofit.gsonConverter)

    testImplementation(Test.junit5)
    testImplementation(Test.truth)
    testImplementation(Test.mockk)
    testImplementation(OkHttp.mockWebServer)
}
