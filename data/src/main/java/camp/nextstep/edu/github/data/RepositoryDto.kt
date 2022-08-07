package camp.nextstep.edu.github.data

import com.google.gson.annotations.SerializedName

/**
 * Created by link.js on 2022. 08. 05..
 */
data class RepositoryDto(
    @SerializedName("full_name") val fullName: String,
    @SerializedName("description") val description: String
)
