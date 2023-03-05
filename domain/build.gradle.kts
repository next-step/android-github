plugins {
    kotlin("jvm")
    kotlin("kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation ("com.google.dagger:hilt-core:2.41")
    kapt ("com.google.dagger:hilt-compiler:2.41")
}
