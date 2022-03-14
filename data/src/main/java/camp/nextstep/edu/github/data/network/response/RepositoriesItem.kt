package camp.nextstep.edu.github.data.network.response

import com.google.gson.annotations.SerializedName

internal data class RepositoriesItem(
    @SerializedName("full_name")
    val fullName: String,

    @SerializedName("description")
    val description: String?
)