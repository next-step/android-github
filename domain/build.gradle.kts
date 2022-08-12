import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id ("kotlin")
    kotlin ("kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation("com.google.dagger:hilt-core:2.42")
    kapt("com.google.dagger:hilt-android-compiler:2.42")
}
