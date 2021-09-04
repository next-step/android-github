const val kotlinVersion = "1.5.21"
const val junit5Version = "5.7.2"

object ComposeConfig {
    const val COMPOSE_VERSION = "1.0.2"

    const val UI = "androidx.compose.ui:ui:$COMPOSE_VERSION"
    const val MATERIAL = "androidx.compose.material:material:$COMPOSE_VERSION"
    const val UI_TOOLING = "androidx.compose.ui:ui-tooling:$COMPOSE_VERSION"
    const val RUNTIME_LIVEDATA = "androidx.compose.runtime:runtime-livedata:$COMPOSE_VERSION"
    const val ACTIVITY = "androidx.activity:activity-compose:1.3.1"
}

object NetworkConfig {
    private const val RETROFIT_VER = "2.9.0"

    const val RETROFIT = "com.squareup.retrofit2:retrofit:$RETROFIT_VER"
    const val CONVERTER_MOSHI = "com.squareup.retrofit2:converter-moshi:$RETROFIT_VER"
}

object ConverterConfig {
    private const val MOSHI_VER = "1.12.0"

    const val MOSHI_KOTLIN = "com.squareup.moshi:moshi-kotlin:$MOSHI_VER"
    const val MOSHI_KOTLIN_CODEGEN = "com.squareup.moshi:moshi-kotlin-codegen:$MOSHI_VER"
}

object TestConfig {
    const val MOCK_WEB_SERVER = "com.squareup.okhttp3:mockwebserver:4.9.1"
}

object CoroutinesConfig {
    const val CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1"
}

object HiltConfig {
    const val HILT_VERSION = "2.38.1"

    const val ANDROID_GRADLE_PLUGIN = "com.google.dagger:hilt-android-gradle-plugin:$HILT_VERSION"
    const val ANDROID = "com.google.dagger:hilt-android:$HILT_VERSION"
    const val COMPILER = "com.google.dagger:hilt-compiler:$HILT_VERSION"
}
