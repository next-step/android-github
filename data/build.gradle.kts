plugins {
    id("kotlin")
    id("kotlin-kapt")
//    id("dagger.hilt.android.plugin")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(project(":domain"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    implementation("org.junit.jupiter:junit-jupiter:$junit5Version")
    runtimeOnly("org.junit.vintage:junit-vintage-engine:$junit5Version") // junit4 지원
    implementation("junit:junit:4.13.2")
    implementation("com.google.truth:truth:1.1.3")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.10.0")
    implementation("com.squareup.okhttp3:mockwebserver:4.10.0")

    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.3.2")
    testImplementation("com.squareup.okhttp3:mockwebserver:4.10.0")
    testImplementation("org.junit.jupiter:junit-jupiter:$junit5Version")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine:$junit5Version") // junit4 지원
    testImplementation("junit:junit:4.13.2")
    testImplementation("com.google.truth:truth:1.1.3")
}