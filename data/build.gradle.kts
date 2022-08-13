plugins {
    id("kotlin")
}

dependencies {
    implementation(project(":domain"))

    implementation ("com.squareup.retrofit2:retrofit:$retrofit2Version")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit2Version")

    testImplementation("org.junit.jupiter:junit-jupiter:$junit5Version")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine:$junit5Version") // junit4 지원
    testImplementation("junit:junit:4.13.2")
    testImplementation("com.google.truth:truth:1.1.3")
    testImplementation("com.squareup.okhttp3:mockwebserver:4.10.0")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
}