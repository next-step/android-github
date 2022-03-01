package com.github.dodobest.data.utils

enum class RESPONSE_STATE {
    OK, FAIL
}

object API {
    const val BASE_URL : String = "https://api.github.com/"
    const val SEARCH_PUBLIC_REPOSITORY: String = "repositories"
}