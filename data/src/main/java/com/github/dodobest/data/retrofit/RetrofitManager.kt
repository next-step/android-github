package com.github.dodobest.data.retrofit

import com.github.dodobest.domain.GithubData
import com.github.dodobest.domain.RESPONSE_STATE
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitManager(
    private val githubApiService : GithubApiService = RetrofitClient.getRetrofit().create(GithubApiService::class.java)
) {
    fun getRepositories(completion: (RESPONSE_STATE, List<GithubData>) -> Unit) {
        val call = githubApiService.getRepositories()

        call.enqueue(object: Callback<List<GithubData>> {
            override fun onResponse(
                call: Call<List<GithubData>>,
                response: Response<List<GithubData>>
            ) {
                completion(RESPONSE_STATE.OK, response.body()!!)
            }

            override fun onFailure(call: Call<List<GithubData>>, t: Throwable) {
                completion(RESPONSE_STATE.FAIL, listOf(GithubData("Error", t.message?: t.toString())))
            }
        })
    }
}