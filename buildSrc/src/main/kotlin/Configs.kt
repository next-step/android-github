const val KOTLIN_VERSION = "1.5.21"
const val JUNIT5_VERSION = "5.7.2"

object Kotlin {
    const val STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:$KOTLIN_VERSION"
}

object Androidx {
    const val CORE = "androidx.core:core-ktx:1.6.0"
    const val APPCOMPAT = "androidx.appcompat:appcompat:1.3.1"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:2.1.3"
    const val GOOGLE_MATERIAL = "com.google.android.material:material:1.4.0"
}

object Test {
    const val JUNIT_JUPITER = "org.junit.jupiter:junit-jupiter:$JUNIT5_VERSION"
    const val JUNIT_VINTAGE_ENGINE = "org.junit.vintage:junit-vintage-engine:$JUNIT5_VERSION"
    const val JUNIT = "junit:junit:4.13.2"
    const val THRUTH = "com.google.truth:truth:1.1.3"
}

object AndroidTest {
    private const val DE_MANNODERMAUS_JUNIT5 = "1.2.2"

    const val JUNIT = "androidx.test.ext:junit:1.1.3"
    const val ESSPRESSO_CORE = "androidx.test.espresso:espresso-core:3.4.0"
    const val JUNIT_JUPITER_API = "org.junit.jupiter:junit-jupiter-api:$JUNIT5_VERSION"
    const val ANDROID_TEST_CORE = "de.mannodermaus.junit5:android-test-core:$DE_MANNODERMAUS_JUNIT5"
    const val ANDROID_TEST_RUNNER = "de.mannodermaus.junit5:android-test-runner:$DE_MANNODERMAUS_JUNIT5"
}
