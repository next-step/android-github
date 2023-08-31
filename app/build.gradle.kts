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

        testInstrumentationRunner = "camp.nextstep.edu.github.CustomTestRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    implementation(project(":data"))
    implementation(project(":domain"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Version.kotlin}")
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.0")
    implementation("com.google.android.material:material:1.7.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.fragment:fragment-ktx:1.5.5")

    testImplementation("junit:junit:4.13.2")
    testImplementation("com.google.truth:truth:1.1.3")
    testImplementation("androidx.arch.core:core-testing:2.1.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("androidx.fragment:fragment-ktx:${Version.fragmentKtx}")

    // Junit
    testImplementation("junit:junit:${Version.junit4}")

    // Test
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutineTest}")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.coroutineTest}")

    // Mockk
    testImplementation("io.mockk:mockk:${Version.mockk}")

    // Live data test
    testImplementation("androidx.arch.core:core-testing:${Version.coreTesting}")

    // Ui test
    testImplementation("org.robolectric:robolectric:${Version.robolectic}")
    testImplementation("androidx.test.espresso:espresso-core:${Version.espressoCore}")

    //Android test
    androidTestImplementation("junit:junit:${Version.junit4}")
    androidTestImplementation("com.google.truth:truth:${Version.truth}")
    androidTestImplementation("androidx.arch.core:core-testing:${Version.coreTesting}")
    androidTestImplementation("androidx.test.ext:junit:${Version.extJunit}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${Version.espressoCore}")

    // Hilt
    implementation("com.google.dagger:hilt-android:${Version.hilt}")
    kapt("com.google.dagger:hilt-compiler:${Version.hilt}")
    testImplementation("com.google.dagger:hilt-android-testing:${Version.hilt}")
    kaptTest("com.google.dagger:hilt-android-compiler:${Version.hilt}")
}
