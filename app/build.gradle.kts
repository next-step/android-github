@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    compileSdk = Version.compileSdk

    defaultConfig {
        applicationId = "edu.nextstep.camp.calculator"
        minSdk = Version.minSdk
        targetSdk = Version.targetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.1"
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        dataBinding = true
        compose = true
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Version.kotlin}")
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.0")
    implementation("com.google.android.material:material:1.7.0")

    testImplementation("junit:junit:4.13.2")
    testImplementation("com.google.truth:truth:1.1.3")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // hilt
    implementation("com.google.dagger:hilt-android:2.44.2")
    kapt("com.google.dagger:hilt-android-compiler:2.44.2")

    // compose
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation("androidx.compose.runtime:runtime")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3:1.1.1")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // test
    testImplementation("junit:junit:4.13.2")
    testImplementation("com.google.truth:truth:1.1.3")
    testImplementation("androidx.arch.core:core-testing:2.2.0")
    testImplementation("androidx.test:core-ktx:1.5.0")
    testImplementation("io.mockk:mockk:1.13.7")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
}
