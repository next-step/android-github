object BuildPlugins {
    val android by lazy { "com.android.tools.build:gradle:${Versions.gradlePlugin}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}" }
    val ktlintGradle by lazy { "org.jlleitschuh.gradle:ktlint-gradle:10.0.0" }
    val gradlePluginsAndroidJunit5 by lazy { "de.mannodermaus.gradle.plugins:android-junit5:1.7.1.1" }
}

object Kotlin {
    val kotlinStdlib by lazy { "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}" }
}

object Androidx {
    val core by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val materialDesign by lazy { "com.google.android.material:material:${Versions.material}" }
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }
}

object Network {
    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
    val converterGson by lazy { "com.squareup.retrofit2:converter-gson:${Versions.retrofit}" }
    val gson by lazy { "com.google.code.gson:gson:${Versions.retrofit}" }

    val okHttp by lazy { "com.squareup.okhttp3:okhttp:${Versions.okHttp}" }

    //testImplementation
    val mockWebserver by lazy { "com.squareup.okhttp3:mockwebserver:${Versions.okHttp}" }
}

object Test {
    // testImplementation
    val jUnitJupiter by lazy { "org.junit.jupiter:junit-jupiter:${Versions.jUnit5}" }
    val jUnit by lazy { "junit:junit:${Versions.jUnit}" }
    val truth by lazy { "com.google.truth:truth:${Versions.truth}" }

    // testRuntimeOnly
    val junitVintageEngine by lazy { "org.junit.vintage:junit-vintage-engine:${Versions.jUnit5}" }

    // androidTestImplementation
    val androidxJunit by lazy { "androidx.test.ext:junit:${Versions.androidxJunit}" }
    val espressoCore by lazy { "androidx.test.espresso:espresso-core:${Versions.espressoCore}" }
    val junitJupiterApi by lazy { "org.junit.jupiter:junit-jupiter-api:${Versions.jUnit5}" }
    val androidTestCore by lazy { "de.mannodermaus.junit5:android-test-core:${Versions.jUnit5AndroidTest}" }

    // androidTestRuntimeOnly
    val androidTestRunner by lazy { "de.mannodermaus.junit5:android-test-runner:${Versions.jUnit5AndroidTest}" }
}