const val kotlinVersion = "1.5.21"
const val junit5Version = "5.7.2"

object Androidx {
    const val core = "androidx.core:core-ktx:1.6.0"
    const val appcompat = "androidx.appcompat:appcompat:1.3.1"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.0"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:1.3.3"
    const val googleMaterial ="com.google.android.material:material:1.4.0"
}

object Kotlin {
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"
}

object Hilt {
    private const val version = "2.38.1"

    const val androidGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
    const val android = "com.google.dagger:hilt-android:$version"
    const val androidCompiler = "com.google.dagger:hilt-android-compiler:$version"
    const val core = "com.google.dagger:hilt-core:$version"
    const val compiler = "com.google.dagger:hilt-compiler:$version"
}

object Retrofit {
    private const val version = "2.9.0"
    const val core = "com.squareup.retrofit2:retrofit:$version"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:$version"
}

object OkHttp {
    private const val version = "4.9.1"
    const val core = "com.squareup.okhttp3:okhttp:$version"
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:$version"
}

object Coroutine {
    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0"
    const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.4.2"
}

object Test {
    const val junit4 = "junit:junit:4.13.2"
    const val junit5 = "org.junit.jupiter:junit-jupiter:5.7.2"
    const val junitVintageEngine = "org.junit.vintage:junit-vintage-engine:$junit5Version"
    const val androidxJunit = "androidx.test.ext:junit:1.1.3"
    const val espressoCore = "androidx.test.espresso:espresso-core:3.4.0"

    const val androidTestCore = "de.mannodermaus.junit5:android-test-core:1.2.2"
    const val androidTestRunner = "de.mannodermaus.junit5:android-test-runner:1.2.2"

    const val truth = "com.google.truth:truth:1.1.2"
    const val mockk = "io.mockk:mockk:1.12.0"
}
