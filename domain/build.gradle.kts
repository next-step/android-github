plugins {
    id("kotlin")
    id ("kotlin-kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.dagger:hilt-core:$hiltVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion")

    kapt("com.google.dagger:hilt-android-compiler:$hiltVersion")
}

tasks.withType<Test> {
    useJUnitPlatform()
}