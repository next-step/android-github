plugins {
    id("kotlin")
    id("kotlin-kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation("com.google.dagger:hilt-core:2.44.2")
    kapt("com.google.dagger:hilt-compiler:2.44.2")
}
