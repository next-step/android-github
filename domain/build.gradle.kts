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
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.8.2")
}

tasks.withType<Test> {
    useJUnitPlatform()
}