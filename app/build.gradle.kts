import Versions.AndroidX.appcompatVersion
import Versions.AndroidX.constraintLayoutVersion
import Versions.AndroidX.materialVersion
import Versions.Compose.composeActivityVersion
import Versions.Compose.composeVersion
import Versions.Compose.composeNavVersion
import Versions.Hilt.hiltVersion
import Versions.Hilt.hiltNavComposeVersion
import Versions.Test.espressoVersion
import Versions.Test.junit5Version
import Versions.Test.mannodermausJunit5Version
import Versions.Test.junitVersion
import Versions.Test.truthVersion
import Versions.Test.junitExtensionsVersion
import Versions.kotlinVersion

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlinx-serialization")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "camp.nextstep.edu.github"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
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

    buildFeatures {
        compose = true
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = composeVersion
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    //Hilt
    kapt("com.google.dagger:hilt-android-compiler:$hiltVersion")
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    implementation("androidx.hilt:hilt-navigation-compose:$hiltNavComposeVersion")

    //compose
    implementation("androidx.activity:activity-compose:$composeActivityVersion") // Integration with activities
    implementation("androidx.compose.material:material:$composeVersion") // Compose Material Design
    implementation("androidx.compose.animation:animation:$composeVersion") // Animations
    implementation("androidx.compose.ui:ui-tooling:$composeVersion")// Tooling support (Previews, etc.)
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$composeNavVersion") // Integration with ViewModels

    //kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    implementation("androidx.core:core-ktx:$kotlinVersion")

    //androidx
    implementation("androidx.appcompat:appcompat:$appcompatVersion")
    implementation("com.google.android.material:material:$materialVersion")
    implementation("androidx.constraintlayout:constraintlayout:$constraintLayoutVersion")

    // UI Tests
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
    androidTestImplementation("androidx.test.ext:junit:$junitExtensionsVersion")
    androidTestImplementation("androidx.test.espresso:espresso-core:$espressoVersion")
    androidTestImplementation("org.junit.jupiter:junit-jupiter-api:$junit5Version")
    androidTestImplementation("de.mannodermaus.junit5:android-test-core:$mannodermausJunit5Version")
    androidTestRuntimeOnly("de.mannodermaus.junit5:android-test-runner:$mannodermausJunit5Version")

    //testing
    testImplementation("org.junit.jupiter:junit-jupiter:$junit5Version")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine:$junit5Version") // junit4 지원
    testImplementation("junit:junit:$junitVersion")
    testImplementation("com.google.truth:truth:$truthVersion")


    implementation(project(":domain"))
    implementation(project(":data"))
}
