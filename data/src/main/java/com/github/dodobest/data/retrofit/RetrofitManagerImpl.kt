package com.github.dodobest.data.retrofit

import com.github.dodobest.domain.GithubData
import com.github.dodobest.domain.RESPONSE_STATE
import com.github.dodobest.domain.RetrofitManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class RetrofitManagerImpl(
    private val retrofit : Retrofit
) : RetrofitManager {
    override fun getRepositories(completion: (RESPONSE_STATE, List<GithubData>) -> Unit) {
        val call = retrofit.create(GithubApiService::class.java).getRepositories()

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