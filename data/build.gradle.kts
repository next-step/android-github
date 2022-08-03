plugins {
    id("kotlin")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("com.google.truth:truth:1.1.3")
    testImplementation("io.mockk:mockk:1.12.3")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junit5Version")

    implementation(project(":domain"))

    val retrofitVersion = "2.9.0"
    val okhttpVersion = "4.9.3"
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation("com.squareup.okhttp3:okhttp:$okhttpVersion")
    implementation("com.squareup.okhttp3:logging-interceptor:$okhttpVersion")
    implementation("com.squareup.okhttp3:mockwebserver:$okhttpVersion")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutineVersion")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutineVersion")
}

tasks.withType<Test> {
    useJUnitPlatform()
}