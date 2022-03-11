plugins {
    id("java-library")
    id("kotlin")
    id("kotlinx-serialization")
    id("kotlin-kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(project(":domain"))

    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.google.code.gson:gson:2.9.0")
    implementation("com.squareup.okhttp3:mockwebserver:4.9.3")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.0")

    implementation("com.google.dagger:hilt-core:2.41")
    kapt("com.google.dagger:hilt-android-compiler:2.41")

    testImplementation("org.junit.jupiter:junit-jupiter:$junit5Version")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.0")
    testImplementation("com.google.truth:truth:1.1.3")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine:$junit5Version")
}
