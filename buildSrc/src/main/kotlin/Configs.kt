const val kotlinVersion = "1.5.21"
const val junit5Version = "5.7.2"

object Coroutine {
    const val CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0"
    const val TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.0"
}


object Network {
    private const val RETROFIT_VERSION = "2.9.0"
    private const val OKHTTP_VERSION = "4.9.3"

    const val RETROFIT = "com.squareup.retrofit2:retrofit:$RETROFIT_VERSION"
    const val CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:$RETROFIT_VERSION"
    const val OKHTTP = "com.squareup.okhttp3:okhttp:$OKHTTP_VERSION"

    const val MOCK_WEB_SERVER = "com.squareup.okhttp3:mockwebserver:4.9.3"
}

object Test {
    private const val DE_MANNODERMAUS_JUNIT5_VERSION = "1.3.0"

    const val JUNIT5_JUPITER_API = "org.junit.jupiter:junit-jupiter-api:$junit5Version"
    const val JUNIT5_JUPITER_ENGINE = "org.junit.jupiter:junit-jupiter-engine:$junit5Version"
    const val JUNIT5_JUPITER_PARAMS = "org.junit.jupiter:junit-jupiter-params:$junit5Version"
    const val JUNIT5_VINTAGE_ENGINE = "org.junit.vintage:junit-vintage-engine:$junit5Version"
    const val JUNIT5_ANDROID_TEST_CORE = "de.mannodermaus.junit5:android-test-core:$DE_MANNODERMAUS_JUNIT5_VERSION"
    const val JUNIT5_ANDROID_TEST_RUNNER = "de.mannodermaus.junit5:android-test-runner:$DE_MANNODERMAUS_JUNIT5_VERSION"

    const val ANDROIDX_JUNIT = "androidx.test.ext:junit:1.1.3"
    const val TRUTH = "com.google.truth:truth:1.1.3"

    const val MOCKK = "io.mockk:mockk:1.12.2"
    const val ESSPRESSO_CORE = "androidx.test.espresso:espresso-core:3.4.0"
}