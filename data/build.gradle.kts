import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("kotlin")
    id("kotlin-kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.freeCompilerArgs += "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi"
}

dependencies {
    implementation(KotlinStdLib)
    implementation(CoroutinesCore)

    val retrofitVersion = "2.9.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")

    kapt(HiltKapt)
    implementation(HiltCore)

    testImplementation(JunitJupyter)
    testRuntimeOnly(JunitVintageEngine) // junit4 지원
    testImplementation(Junit4)
    testImplementation(MockK)
    testImplementation(Truth)
    testImplementation(CoroutinesTest)
    testImplementation("com.squareup.okhttp3:mockwebserver:4.10.0")

    implementation(project(":domain"))
}
