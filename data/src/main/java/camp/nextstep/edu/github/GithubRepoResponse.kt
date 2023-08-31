package camp.nextstep.edu.github

import com.google.gson.annotations.SerializedName

data class GithubRepoResponse(
	@SerializedName("full_name")
	val fullName: String,

	@SerializedName("description")
	val description: String,
)

fun GithubRepoResponse.asResource(): GithubRepoResource = GithubRepoResource(fullName = fullName, description = description¡)