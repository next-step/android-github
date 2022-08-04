package camp.nextstep.edu.github.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * 클래스에 대한 간단한 설명이나 참고 url을 남겨주세요.
 * Created by jeongjinhong on 2022. 08. 04..
 */
object ApiServiceFactory {
    private const val BASE_URL = "https://api.github.com"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService = retrofit.create(ApiService::class.java)
}