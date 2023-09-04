package camp.nextstep.edu.github

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {

	private const val BASE_URL = "https://api.github.com/"

	private fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()

	fun provideRetrofit(): Retrofit = Retrofit.Builder()
		.baseUrl(BASE_URL)
		.client(provideOkHttpClient())
		.addConverterFactory(GsonConverterFactory.create())
		.build()

	fun provideGithubService(retrofit: Retrofit): GithubService = retrofit.create(GithubService::class.java)
}