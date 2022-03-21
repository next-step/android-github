package com.github.dodobest.data.retrofit

import com.github.dodobest.domain.GithubData
import com.google.gson.annotations.SerializedName

data class GithubDataResponse(
    @SerializedName("full_name")
    val fullName: String?,
    val description: String?
) {
    fun toData() : GithubData {
        return GithubData(fullName, description)
    }
}
