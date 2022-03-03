plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-parcelize")
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Compose.COMPOSE_VERSION
    }
    testOptions {
        unitTests.isReturnDefaultValues = true
    }
}

dependencies {
    implementation(project(":data"))
    implementation(project(":domain"))

    Kotlin.run {
        implementation(STDLIB)
    }

    Coroutines.run {
        implementation(CORE)
        implementation(ANDROID)
    }

    Hilt.run {
        implementation(ANDROID)
        kapt(COMPILER)
    }

    Android.run {
        implementation(CORE)
        implementation(APPCOMPAT)
        implementation(MATERIAL)
        implementation(CONSTRAINTLAYOUT)
    }

    Test.run {
        testRuntimeOnly(ENGINE)
        testImplementation(JUPITER)
        testImplementation(ASSERTJ)
        testImplementation(JUNIT4)
        testImplementation(TRUTH)
        testImplementation(MOCKK)
        androidTestImplementation(EXT_JUNIT)
        androidTestImplementation(ESPRESSO_CORE)
        androidTestImplementation(API)
        androidTestImplementation(ANDROID_TEST_CORE)
        androidTestRuntimeOnly(ANDROID_TEST_RUNNER)
    }
}
