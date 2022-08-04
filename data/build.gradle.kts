plugins {
    id("kotlin")
    id("kotlin-kapt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":domain"))

    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("com.google.truth:truth:1.1.3")
    testImplementation("io.mockk:mockk:1.12.3")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junit5Version")
}

tasks.withType<Test> {
    useJUnitPlatform()
