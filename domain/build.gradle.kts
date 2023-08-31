plugins {
    id("kotlin")
    id("kotlin-kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    // hilt
    implementation("com.google.dagger:hilt-core:${Version.hilt}")
    kapt("com.google.dagger:hilt-compiler:${Version.hilt}")
}
