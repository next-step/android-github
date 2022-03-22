package com.github.dodobest.data.retrofit

import com.github.dodobest.domain.GithubData
import com.github.dodobest.domain.RetrofitManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

internal class RetrofitManagerImpl(
    private val retrofit : Retrofit
) : RetrofitManager {
    override fun getRepositories(onSuccess: (List<GithubData>) -> Unit, onFailure: (Throwable) -> Unit) {
        val call = retrofit.create(GithubApiService::class.java).getRepositories()

        call.enqueue(object: Callback<List<GithubDataResponse>> {
            override fun onResponse(
                call: Call<List<GithubDataResponse>>,
                data: Response<List<GithubDataResponse>>
            ) {
                onSuccess(data.body()!!.toList().map { it.toData() })
            }

            override fun onFailure(call: Call<List<GithubDataResponse>>, t: Throwable) {
                onFailure(t)
            }
        })
    }
}