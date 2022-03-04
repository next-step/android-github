plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("de.mannodermaus.android-junit5")
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
        dataBinding = true
    }
}

dependencies {
    implementation(project(":domain"))

    Kotlin.apply {
        implementation(STDLIB)
    }

    Androidx.apply {
        implementation(CORE)
        implementation(APPCOMPAT)
        implementation(MATERIAL)
        implementation(CONSTRAINT_LAYOUT)
    }

    Test.apply {
        testImplementation(JUNIT5_JUPITER)
        testImplementation(TRUTH)
        testImplementation(MOCKK)

        testRuntimeOnly(JUNIT5_VINTAGE_ENGINE)

        androidTestImplementation(JUNIT5_JUPITER_API)
        androidTestImplementation(JUNIT5_ANDROID_TEST_CORE)
        androidTestImplementation(ANDROIDX_JUNIT)
        androidTestImplementation(ESPRESSO_CORE)

        androidTestRuntimeOnly(JUNIT5_ANDROID_TEST_RUNNER)
    }
}
