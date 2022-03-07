plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("de.mannodermaus.android-junit5")
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "camp.nextstep.edu.github"
        minSdk = 21
        targetSdk = 31
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

    Kotlin.run {
        implementation(stdlib)
    }

    AndroidX.run {
        implementation(core)
        implementation(appcompat)
        implementation(constraintLayout)
    }

    Google.run {
        implementation(material)
    }

    Test.run {
        testImplementation(junit4)
        testImplementation(junit5)
        testRuntimeOnly(junitVintageEngine)

        testImplementation(truth)

        androidTestImplementation(espresso)
        androidTestImplementation(androidxJunit)

        androidTestImplementation(junit5JupiterApi)
        androidTestImplementation(androidTestCore)
        androidTestRuntimeOnly(androidTestRunner)
    }
}
