const val KOTLIN_VERSION = "1.5.21"
const val JUNIT5_VERSION = "5.8.2"
const val COMPOSE_VERSION = "1.0.5"

object Kotlin {
    const val STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:$KOTLIN_VERSION"
}

object Coroutines {
    const val CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0"
    const val TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.0"
}

object Androidx {
    const val CORE = "androidx.core:core-ktx:1.6.0"
    const val APPCOMPAT = "androidx.appcompat:appcompat:1.3.1"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:2.1.3"
    const val GOOGLE_MATERIAL = "com.google.android.material:material:1.4.0"
}

object Compose {
    const val UI = "androidx.compose.ui:ui:$COMPOSE_VERSION"
    const val UI_TOOLING = "androidx.compose.ui:ui-tooling:$COMPOSE_VERSION"
    const val FOUNDATION = "androidx.compose.foundation:foundation:$COMPOSE_VERSION"
    const val MATERIAL_DESIGN = "androidx.compose.material:material:$COMPOSE_VERSION"
    const val MATERIAL_ICONS = "androidx.compose.material:material-icons-core:$COMPOSE_VERSION"
    const val MATERIAL_ICONS_EXTENDED = "androidx.compose.material:material-icons-extended:$COMPOSE_VERSION"
    const val RUNTIME_LIVEDATA = "androidx.compose.runtime:runtime-livedata:$COMPOSE_VERSION"
    const val ACTIVITY = "androidx.activity:activity-compose:1.3.1"

    const val ANDROID_TEST = "androidx.compose.ui:ui-test-junit4:$COMPOSE_VERSION"
}

object Hilt {
    private const val VERSION = "2.38.1"

    const val ANDROID_GRADLE_PLUGIN = "com.google.dagger:hilt-android-gradle-plugin:$VERSION"
    const val ANDROID = "com.google.dagger:hilt-android:$VERSION"
    const val ANDROID_COMPILER = "com.google.dagger:hilt-android-compiler:$VERSION"
    const val COMPILER = "com.google.dagger:hilt-compiler:$VERSION"
    const val CORE = "com.google.dagger:hilt-core:$VERSION"
}

object Networking {
    private const val RETROFIT_VERSION = "2.9.0"
    private const val MOSHI_VERSION = "1.12.0"
    private const val OKHTTP_VERSION = "4.9.3"

    const val RETROFIT = "com.squareup.retrofit2:retrofit:$RETROFIT_VERSION"
    const val CONVERTER_MOSHI = "com.squareup.retrofit2:converter-moshi:$RETROFIT_VERSION"

    const val MOSHI_KOTLIN = "com.squareup.moshi:moshi-kotlin:$MOSHI_VERSION"
    const val MOSHI_KOTLIN_CODEGEN = "com.squareup.moshi:moshi-kotlin-codegen:$MOSHI_VERSION"

    const val OKHTTP = "com.squareup.okhttp3:okhttp-bom:$OKHTTP_VERSION"
    const val MOCK_WEB_SERVER = "com.squareup.okhttp3:mockwebserver:$OKHTTP_VERSION"
}

object Test {
    private const val DE_MANNODERMAUS_JUNIT5_VERSION = "1.3.0"

    const val JUNIT5_JUPITER_API = "org.junit.jupiter:junit-jupiter-api:$JUNIT5_VERSION"
    const val JUNIT5_JUPITER_ENGINE = "org.junit.jupiter:junit-jupiter-engine:$JUNIT5_VERSION"
    const val JUNIT5_JUPITER_PARAMS = "org.junit.jupiter:junit-jupiter-params:$JUNIT5_VERSION"
    const val JUNIT5_VINTAGE_ENGINE = "org.junit.vintage:junit-vintage-engine:$JUNIT5_VERSION"
    const val JUNIT5_ANDROID_TEST_CORE = "de.mannodermaus.junit5:android-test-core:$DE_MANNODERMAUS_JUNIT5_VERSION"
    const val JUNIT5_ANDROID_TEST_RUNNER = "de.mannodermaus.junit5:android-test-runner:$DE_MANNODERMAUS_JUNIT5_VERSION"

    const val ANDROIDX_JUNIT = "androidx.test.ext:junit:1.1.3"
    const val TRUTH = "com.google.truth:truth:1.1.3"

    const val MOCKK = "io.mockk:mockk:1.12.2"
    const val ESSPRESSO_CORE = "androidx.test.espresso:espresso-core:3.4.0"
    const val TURBINE = "app.cash.turbine:turbine:0.7.0"
}