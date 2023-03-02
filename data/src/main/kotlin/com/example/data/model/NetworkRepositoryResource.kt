package com.example.data.model

import com.example.domain.model.RepositoryResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class NetworkRepositoryResource(
    @SerialName("full_name") val fullName: String,
    val description: String
) {

    fun toRepositoryResource(): RepositoryResource = RepositoryResource(fullName, description)

}
