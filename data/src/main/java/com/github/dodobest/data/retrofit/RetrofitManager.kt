package com.github.dodobest.data.retrofit

import com.github.dodobest.data.utils.API
import com.github.dodobest.data.utils.RESPONSE_STATE
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Response

class RetrofitManager {

    companion object {
        val instance = RetrofitManager()
    }

    // Retrofit Interface 가져오기
    private val iRetrofit : IRetrofit = RetrofitClient.getClient(API.BASE_URL).create(IRetrofit::class.java)

    fun getRepositories(completion: (RESPONSE_STATE, String) -> Unit) {
        val call = iRetrofit.getRepositories()

        call.enqueue(object: retrofit2.Callback<JsonElement>{
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                println("RetrofitManager - onResponse() called / response : ${response.raw()}")
                completion(RESPONSE_STATE.OK, response.body().toString())
            }

            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                println("RetrofitManager - onFailure() called")
                completion(RESPONSE_STATE.FAIL, t.toString())
            }
        })
    }
}