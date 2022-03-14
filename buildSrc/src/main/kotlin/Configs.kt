const val kotlinVersion = "1.5.21"
const val junit5Version = "5.7.2"

object Retrofit {
    private const val retrofitVersion = "2.9.0"

    const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
}

object OkHttp {
    private const val okHttpVersion = "4.9.1"

    const val core = "com.squareup.okhttp3:okhttp:$okHttpVersion"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$okHttpVersion"
}

object ConverterConfig {
    private const val moshiVersion = "1.12.0"

    const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:$moshiVersion"
    const val moshiKotlinCodeGen = "com.squareup.moshi:moshi-kotlin-codegen:$moshiVersion"
}

object TestConfig {
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:4.9.1"
    const val truth = "com.google.truth:truth:1.1.3"
}

object CoroutinesConfig {
    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1"
}

object Hilt {
    private const val hiltVersion = "2.41"
    const val hilt = "com.google.dagger:hilt-android:$hiltVersion"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:$hiltVersion"
}