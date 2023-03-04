plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id("kotlin-kapt")

}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(project(":domain"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Version.kotlin}")
    // Junit
    testImplementation("junit:junit:${Version.JUNIT4}")
    testImplementation("com.google.truth:truth:${Version.TRUTH}")

    // Mockk
    testImplementation("io.mockk:mockk:${Version.MOCKK}")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:${Version.RETROFIT}")
    implementation("com.squareup.retrofit2:converter-moshi:${Version.CONVERTER_MOSHI}")

    // Moshi
    implementation("com.squareup.moshi:moshi:${Version.MOSHI}")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:${Version.MOSHI}")

    // Okhttp
    implementation("com.squareup.okhttp3:okhttp:${Version.OKHTTP}")
    implementation("com.squareup.okhttp3:logging-interceptor:${Version.OKHTTP}")

    // Coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.COROUTINE}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.COROUTINE_ANDROID}")

    //Mock server
    testImplementation("com.squareup.okhttp3:mockwebserver:${Version.MOCK_WEB_SERVER}")

}