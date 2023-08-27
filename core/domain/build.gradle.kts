plugins {
    id("kotlin")
    id("org.jlleitschuh.gradle.ktlint") version "11.5.0"
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
dependencies {
    implementation("com.google.code.gson:gson:2.10.1")

    testImplementation("junit:junit:4.13.2")
    testImplementation("com.google.truth:truth:1.1.4")
}
