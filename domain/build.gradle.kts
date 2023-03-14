plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id("kotlin-kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Version.kotlin}")

    // Junit
    testImplementation("junit:junit:${Version.JUNIT4}")
    testImplementation("com.google.truth:truth:${Version.TRUTH}")

    // Mockk
    testImplementation("io.mockk:mockk:${Version.MOCKK}")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:${Version.RETROFIT}")
    implementation("com.squareup.retrofit2:converter-moshi:${Version.CONVERTER_MOSHI}")

    //Hilt
    implementation( "com.google.dagger:hilt-core:2.45")
    kapt( "com.google.dagger:hilt-compiler:2.45")
}
