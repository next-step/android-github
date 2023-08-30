plugins {
    id("kotlin")
    id("com.google.devtools.ksp")
    id("org.jlleitschuh.gradle.ktlint") version "11.5.0"
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Version.kotlin}")
    implementation("com.squareup.retrofit2:retrofit:${Version.retrofit}")
    implementation("com.squareup.retrofit2:converter-gson:${Version.retrofit}")
    implementation(project(":core:domain"))

    testImplementation("junit:junit:4.13.2")
    testImplementation("com.google.truth:truth:1.1.4")
    testImplementation("com.squareup.okhttp3:mockwebserver:4.11.0")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.1")

    implementation("com.google.dagger:hilt-core:2.47")
    ksp("com.google.dagger:hilt-android-compiler:2.47")
}
