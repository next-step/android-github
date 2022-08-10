plugins {
    id("kotlin")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(project(":domain"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")

    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")

    testImplementation("com.squareup.okhttp3:mockwebserver:4.10.0")

    testImplementation("org.junit.jupiter:junit-jupiter:$junit5Version")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine:$junit5Version") // junit4 지원
    testImplementation("com.google.truth:truth:1.1.3")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutineVersion")
}

tasks.withType<Test> {
    useJUnitPlatform()
}