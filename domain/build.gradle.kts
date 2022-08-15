plugins {
    id("kotlin")
    kotlin("kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
dependencies{
    implementation("com.google.dagger:hilt-core:$hiltVersion")
    kapt("com.google.dagger:hilt-compiler:$hiltVersion")
}