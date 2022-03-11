const val KOTLIN_VERSION = "1.5.21"
const val HILT_VERSION = "2.38.1"

object Kotlin {
    const val STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:$KOTLIN_VERSION"
}

object Androidx {
    const val CORE = "androidx.core:core-ktx:1.6.0"
    const val APPCOMPAT = "androidx.appcompat:appcompat:1.3.1"
    const val MATERIAL = "com.google.android.material:material:1.4.0"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:2.1.3"
    const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:1.4.1"
}

object Network {
    private const val RETROFIT_VERSION = "2.9.0"
    private const val MOSHI_VERSION = "1.13.0"
    private const val OKHTTP_VERSION = "4.9.3"

    const val RETROFIT = "com.squareup.retrofit2:retrofit:$RETROFIT_VERSION"
    const val CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:$RETROFIT_VERSION"
    //const val CONVERTER_MOSHI = "com.squareup.retrofit2:converter-moshi:$RETROFIT_VERSION"

    const val MOSHI_KOTLIN = "com.squareup.moshi:moshi-kotlin:$MOSHI_VERSION"
    const val MOSHI_KOTLIN_CODEGEN = "com.squareup.moshi:moshi-kotlin-codegen:$MOSHI_VERSION"

    const val OKHTTP = "com.squareup.okhttp3:okhttp:$OKHTTP_VERSION"

    //testImplementation
    const val MOCK_WEB_SERVER = "com.squareup.okhttp3:mockwebserver:4.9.3"
}

object Coroutine {
    private const val COROUTINE_VERSION = "1.6.0"

    const val CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$COROUTINE_VERSION"
    const val TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$COROUTINE_VERSION"
}

object HILT {
    const val CORE = "com.google.dagger:hilt-core:$HILT_VERSION"
    const val COMPILER = "com.google.dagger:hilt-compiler:$HILT_VERSION"

    const val ANDROID = "com.google.dagger:hilt-android:$HILT_VERSION"
    const val ANDROID_COMPILER = "com.google.dagger:hilt-android-compiler:$HILT_VERSION"
}

object Test {
    private const val JUNIT5_VERSION = "5.7.2"
    private const val JUNIT5_ANDROID_TEST_VERSION = "1.3.0"

    //testImplementation
    const val JUNIT5_JUPITER = "org.junit.jupiter:junit-jupiter:$JUNIT5_VERSION"
    const val JUNIT = "junit:junit:4.13.2"
    const val TRUTH = "com.google.truth:truth:1.1.3"
    const val MOCKK = "io.mockk:mockk:1.12.2"

    //testRuntimeOnly
    const val JUNIT5_VINTAGE_ENGINE = "org.junit.vintage:junit-vintage-engine:$JUNIT5_VERSION"

    //androidTestImplementation
    const val JUNIT5_JUPITER_API = "org.junit.jupiter:junit-jupiter-api:$JUNIT5_VERSION"
    const val JUNIT5_ANDROID_TEST_CORE = "de.mannodermaus.junit5:android-test-core:$JUNIT5_ANDROID_TEST_VERSION"
    const val ANDROIDX_JUNIT = "androidx.test.ext:junit:1.1.3"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:3.4.0"

    //androidTestRuntimeOnly
    const val JUNIT5_ANDROID_TEST_RUNNER = "de.mannodermaus.junit5:android-test-runner:$JUNIT5_ANDROID_TEST_VERSION"
}
