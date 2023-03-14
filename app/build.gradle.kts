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
    implementation(project(":domain"))
    implementation(project(":data"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Version.kotlin}")
    implementation("androidx.core:core-ktx:${Version.CORE_KTX}")
    implementation("androidx.appcompat:appcompat:${Version.APP_COMPAT}")
    implementation("com.google.android.material:material:${Version.MATERIAL}")
    implementation("androidx.constraintlayout:constraintlayout:${Version.CONSTRAINT_LAYOUT}")
    implementation("androidx.fragment:fragment-ktx:${Version.FRAGMENT_KTX}")

    // Junit
    testImplementation("junit:junit:${Version.JUNIT4}")
    testImplementation("com.google.truth:truth:${Version.TRUTH}")
    testImplementation("androidx.test.ext:junit:${Version.EXT_JUNIT}")
    // Live data test
    testImplementation("androidx.arch.core:core-testing:${Version.CORE_TESTING}")

    // Ui test
    testImplementation("org.robolectric:robolectric:${Version.ROBOLECTRIC}")
    testImplementation("androidx.test.espresso:espresso-core:${Version.ESPRESSO_CORE}")

    //Android test
    androidTestImplementation("junit:junit:${Version.JUNIT4}")
    androidTestImplementation("com.google.truth:truth:${Version.TRUTH}")
    androidTestImplementation("androidx.arch.core:core-testing:${Version.CORE_TESTING}")
    androidTestImplementation("androidx.test.ext:junit:${Version.EXT_JUNIT}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${Version.ESPRESSO_CORE}")
    androidTestImplementation("org.robolectric:robolectric:${Version.ROBOLECTRIC}")

    // Room
    implementation("androidx.room:room-runtime:${Version.ROOM}")
    implementation("androidx.room:room-ktx:${Version.ROOM}")

    // Mockk
    testImplementation("io.mockk:mockk:${Version.MOCKK}")
    androidTestImplementation("io.mockk:mockk-android:${Version.MOCKK}")

    //Hilt
    implementation("com.google.dagger:hilt-android:${Version.HILT}")
    implementation("com.google.dagger:hilt-android:2.44")

    implementation("com.google.dagger:hilt-android:2.45")
    implementation( "com.google.dagger:hilt-core:2.45")
    kapt("com.google.dagger:hilt-compiler:2.45")
    // For local unit tests
    testImplementation("com.google.dagger:hilt-android-testing:2.45")
    testAnnotationProcessor("com.google.dagger:hilt-compiler:2.45")

}
kapt {
    correctErrorTypes = true
}
