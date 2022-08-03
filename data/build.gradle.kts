plugins {
    id("kotlin")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(KotlinStdLib)

    testImplementation(JunitJupyter)
    testRuntimeOnly(JunitVintageEngine) // junit4 지원
    testImplementation(Junit4)
    testImplementation(Truth)

    implementation(project(":domain"))
}
