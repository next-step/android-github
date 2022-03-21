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

    Network.apply {
        implementation(retrofit)
        implementation(converterGson)
        implementation(gson)
        implementation(okHttp)

        testImplementation(mockWebserver)
    }

    Test.apply {
        testImplementation(truth)
        testImplementation(testTruth)
    }
}