const val junit5Version = "5.7.2"

object AndroidX {
    const val core = "androidx.core:core-ktx:1.7.0"
    const val appcompat = "androidx.appcompat:appcompat:1.4.1"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.3"
}

object Google {
    const val material = "com.google.android.material:material:1.5.0"
}

object Kotlin {
    const val version = "1.6.10"
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:$version"
}

object Test {
    private const val junit5Version = "5.8.2"
    private const val androidJunit5Version = "1.3.0"

    const val junit4 = "junit:junit:4.13.2"
    const val androidxJunit = "androidx.test.ext:junit:1.1.3"
    const val espresso = "androidx.test.espresso:espresso-core:3.4.0"

    const val junit5 = "org.junit.jupiter:junit-jupiter:$junit5Version"
    const val junitVintageEngine = "org.junit.vintage:junit-vintage-engine:$junit5Version"
    const val junit5JupiterApi = "org.junit.jupiter:junit-jupiter-api:$junit5Version"
    const val androidTestCore = "de.mannodermaus.junit5:android-test-core:$androidJunit5Version"
    const val androidTestRunner = "de.mannodermaus.junit5:android-test-runner:$androidJunit5Version"

    const val truth = "com.google.truth:truth:1.1.3"
}
