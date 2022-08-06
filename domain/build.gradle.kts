plugins {
    id("kotlin")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
}

dependencies {
    implementation(KotlinStdLib)
    implementation(CoroutinesCore)

    testImplementation(JunitJupyter)
    testRuntimeOnly(JunitVintageEngine) // junit4 지원
    testImplementation(Junit4)
    testImplementation(Truth)
    testImplementation(CoroutinesTest)
}
