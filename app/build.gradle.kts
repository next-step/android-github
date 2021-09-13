plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("de.mannodermaus.android-junit5")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 30

    defaultConfig {
        applicationId = "camp.nextstep.edu.github"
        minSdk = 21
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunnerArguments["runnerBuilder"] =
            "de.mannodermaus.junit5.AndroidJUnit5Builder"
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

    implementation(Kotlin.stdlib)
    implementation(Androidx.core)
    implementation(Androidx.appcompat)
    implementation(Androidx.fragmentKtx)

    implementation(Androidx.googleMaterial)
    implementation(Androidx.constraintLayout)

    implementation(Hilt.android)
    kapt(Hilt.androidCompiler)

    testImplementation(Test.junit5)
    testRuntimeOnly(Test.junitVintageEngine) // junit4 지원
    testImplementation(Test.truth)
    testImplementation(Test.mockk)
    testImplementation(Coroutine.test)

    androidTestImplementation(Test.androidxJunit)
    androidTestImplementation(Test.espressoCore)
    androidTestImplementation(Test.junit5)
    androidTestImplementation(Test.androidTestCore)
    androidTestRuntimeOnly(Test.androidTestRunner)
}
