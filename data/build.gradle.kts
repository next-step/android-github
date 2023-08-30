plugins {
    id("kotlin")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(project(":domain"))

    // retrofit
    implementation("com.squareup.retrofit2:retrofit:${Version.retrofit}")
    implementation("com.squareup.retrofit2:converter-gson:${Version.retrofit}")
    implementation("com.squareup.okhttp3:okhttp:${Version.okHttp}")
    implementation("com.squareup.okhttp3:logging-interceptor:${Version.okHttp}")
    implementation("com.squareup.okhttp3:mockwebserver:${Version.okHttp}")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutineTest}")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.coroutineTest}")

    testImplementation("org.junit.jupiter:junit-jupiter:${Version.junit}")
    testImplementation("com.google.truth:truth:${Version.truth}")
}
