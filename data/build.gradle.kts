plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("de.mannodermaus.android-junit5")
}

android {
    compileSdk = 30

    defaultConfig {
        minSdk = 21
        targetSdk = 30

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunnerArguments["runnerBuilder"] =
            "de.mannodermaus.junit5.AndroidJUnit5Builder"

        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
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
        implementation(GOOGLE_MATERIAL)
    }

    Test.apply {
        testImplementation(JUNIT4)
        testImplementation(JUNIT5)
        testRuntimeOnly(JUNIT5_VINTAGE_ENGINE) // junit4 지원
        testImplementation(THRUTH)

        androidTestImplementation(ANDROIDX_JUNIT)
        androidTestImplementation(JUNIT5)
        androidTestImplementation(JUNIT5_JUPITER_API)
        androidTestImplementation(JUNIT5_ANDROID_TEST_CORE)
        androidTestImplementation(ESSPRESSO_CORE)
        androidTestRuntimeOnly(JUNIT5_ANDROID_TEST_RUNNER)
    }
}