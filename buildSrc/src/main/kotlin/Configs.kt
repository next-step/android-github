object Kotlin {
    private const val KOTLIN_VERSION = "1.6.10"

    const val STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:$KOTLIN_VERSION"
    const val GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:$KOTLIN_VERSION"
}

object Classpath {
    const val GRADLE = "com.android.tools.build:gradle:7.1.2"
    const val KTLINT = "org.jlleitschuh.gradle:ktlint-gradle:10.0.0"
    const val ANDROID_JUNIT5 = "de.mannodermaus.gradle.plugins:android-junit5:1.7.1.1"
}

object Test {
    private const val JUNIT5_VERSION = "5.8.2"

    const val JUPITER = "org.junit.jupiter:junit-jupiter:$JUNIT5_VERSION"
    const val ENGINE = "org.junit.vintage:junit-vintage-engine:$JUNIT5_VERSION" // junit4 지원
    const val API = "org.junit.jupiter:junit-jupiter-api:$JUNIT5_VERSION"
    const val JUNIT4 = "junit:junit:4.13.2"
    const val TRUTH = "com.google.truth:truth:1.1.3"
    const val EXT_JUNIT = "androidx.test.ext:junit:1.1.3"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:3.4.0"
    const val ANDROID_TEST_CORE = "de.mannodermaus.junit5:android-test-core:1.2.2"
    const val ANDROID_TEST_RUNNER = "de.mannodermaus.junit5:android-test-runner:1.2.2"
    const val MOCK_WEB_SERVER = "com.squareup.okhttp3:mockwebserver:4.9.3"
    const val ASSERTJ = "org.assertj:assertj-core:3.22.0"
    const val MOCKK = "io.mockk:mockk:1.12.3"
}

object Coroutines {
    private const val COROUTINES_VERSION = "1.6.0"

    const val CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$COROUTINES_VERSION"
    const val ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$COROUTINES_VERSION"
}

object Compose {
    private const val COMPOSE_VERSION = "1.1.0"

    const val UI = "androidx.compose.ui:ui:$COMPOSE_VERSION"
    const val MATERIAL = "androidx.compose.material:material:$COMPOSE_VERSION"
    const val UI_TOOLING = "androidx.compose.ui:ui-tooling:$COMPOSE_VERSION"
    const val RUNTIME_LIVEDATA = "androidx.compose.runtime:runtime-livedata:$COMPOSE_VERSION"
}

object Android {
    const val CORE = "androidx.core:core-ktx:1.7.0"
    const val APPCOMPAT = "androidx.appcompat:appcompat:1.4.1"
    const val CONSTRAINTLAYOUT = "androidx.constraintlayout:constraintlayout:2.1.3"
    const val MATERIAL = "com.google.android.material:material:1.5.0"
    const val FRAGMENT = "androidx.fragment:fragment-ktx:1.4.1"
    const val LIFECYCLE = "androidx.lifecycle:lifecycle-runtime-ktx:2.4.0"
    const val ACTIVITY = "androidx.activity:activity-compose:1.4.0"
}

object Hilt {
    private const val HILT_VERSION = "2.41"

    const val GRADLE_PLUGIN = "com.google.dagger:hilt-android-gradle-plugin:$HILT_VERSION"
    const val ANDROID = "com.google.dagger:hilt-android:$HILT_VERSION"
    const val COMPILER = "com.google.dagger:hilt-compiler:$HILT_VERSION"
    const val CORE = "com.google.dagger:hilt-core:$HILT_VERSION"
}

object Network {
    private const val RETROFIT_VER = "2.9.0"

    const val RETROFIT = "com.squareup.retrofit2:retrofit:$RETROFIT_VER"
    const val CONVERTER_MOSHI = "com.squareup.retrofit2:converter-moshi:$RETROFIT_VER"
}

object Converter {
    private const val MOSHI_VER = "1.13.0"

    const val MOSHI_KOTLIN = "com.squareup.moshi:moshi-kotlin:$MOSHI_VER"
    const val MOSHI_KOTLIN_CODEGEN = "com.squareup.moshi:moshi-kotlin-codegen:$MOSHI_VER"
}
