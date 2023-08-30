package com.nextstep.edu.data.model

import com.google.gson.annotations.SerializedName
import com.nextstep.edu.domain.model.Repository

data class RepositoryResponse(
    @SerializedName("full_name")
    val fullName: String,

    @SerializedName("description")
    val description: String
) {
    fun toDomain(): Repository {
        return Repository(fullName = this.fullName, description = this.description)
    }
}
