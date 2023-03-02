package camp.nextstep.edu.github.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchResponse(
    val repositories: List<Repository>,
)
