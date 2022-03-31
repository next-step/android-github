plugins {
    id("java-library")
    id("kotlin")
    kotlin("jvm")
    kotlin("kapt")
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

    Hilt.apply {
        implementation(hilt)
        kapt(hiltAndroidCompiler)
    }

    Test.apply {
        testImplementation(truth)
    }
}