plugins {
    id("kotlin")
    id("kotlin-kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {

    // Test
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutineTest}")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.coroutineTest}")

    testImplementation("org.junit.jupiter:junit-jupiter:${Version.junit}")
    testImplementation("com.google.truth:truth:${Version.truth}")

    // Mockk
    testImplementation("io.mockk:mockk:${Version.mockk}")

    // hilt
    implementation("com.google.dagger:hilt-core:${Version.hilt}")
    kapt("com.google.dagger:hilt-compiler:${Version.hilt}")
}

tasks.test {
    useJUnitPlatform()
}
