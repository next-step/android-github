plugins {
    id("java-library")
    kotlin("jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(project(":domain"))

    implementation(Network.retrofit)
    implementation(Network.converterGson)
    implementation(Network.gson)
    implementation(Network.okHttp)

    testImplementation(Network.mockWebserver)
}