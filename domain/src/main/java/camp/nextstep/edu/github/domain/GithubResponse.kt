package camp.nextstep.edu.github.domain

import com.google.gson.annotations.SerializedName

/**
 * 클래스에 대한 간단한 설명이나 참고 url을 남겨주세요.
 * Created by jeongjinhong on 2022. 08. 03..
 */
class GithubResponse(
    @SerializedName("full_name")
    val fullName: String? = null,
    @SerializedName("description")
    val description: String? = null
)