plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("de.mannodermaus.android-junit5")
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = "camp.nextstep.edu.github"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

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

    Kotlin.apply {
        implementation(kotlinStdlib)
    }

    Androidx.apply {
        implementation(core)
        implementation(appCompat)
        implementation(materialDesign)
        implementation(constraintLayout)
    }

    Test.apply {
        testImplementation(jUnitJupiter)
        testRuntimeOnly(junitVintageEngine) // junit4 지원
        testImplementation(jUnit)
        testImplementation(truth)
        androidTestImplementation(androidxJunit)
        androidTestImplementation(espressoCore)
        androidTestImplementation(junitJupiterApi)
        androidTestImplementation(androidTestCore)
        androidTestRuntimeOnly(androidTestRunner)
    }
}
