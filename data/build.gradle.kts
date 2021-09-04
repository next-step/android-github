plugins {
    id("java-library")
    id("kotlin")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(project(":domain"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.2")

    testRuntimeOnly("org.junit.vintage:junit-vintage-engine:5.7.2") // junit4 지원
    testImplementation("junit:junit:4.13.2")
    testImplementation("com.google.truth:truth:1.1.3")
}

tasks.test {
    useJUnitPlatform()
}
