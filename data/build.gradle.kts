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

    Coroutines.apply {
        implementation(CORE)
        implementation(TEST)
    }

    Androidx.apply {
        implementation(CORE)
        implementation(APPCOMPAT)
        implementation(GOOGLE_MATERIAL)
    }

    Networking.apply {
        implementation(RETROFIT)
        implementation(CONVERTER_MOSHI)
        implementation(MOSHI_KOTLIN)
        kapt(MOSHI_KOTLIN_CODEGEN)
        implementation(OKHTTP)
        implementation(MOCK_WEB_SERVER)
    }

    Test.apply {
        testImplementation(JUNIT5_JUPITER_API)
        testRuntimeOnly(JUNIT5_JUPITER_ENGINE)
        testImplementation(JUNIT5_JUPITER_PARAMS)
        testRuntimeOnly(JUNIT5_VINTAGE_ENGINE) // junit4 지원
        testImplementation(TRUTH)
        testImplementation(MOCKK)
        testImplementation(TURBINE)

        androidTestImplementation(ANDROIDX_JUNIT)
        androidTestImplementation(JUNIT5_JUPITER_API)
        androidTestImplementation(JUNIT5_ANDROID_TEST_CORE)
        androidTestRuntimeOnly(JUNIT5_ANDROID_TEST_RUNNER)
        androidTestImplementation(ESSPRESSO_CORE)
    }
}