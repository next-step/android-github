package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.Github

/**
 * 클래스에 대한 간단한 설명이나 참고 url을 남겨주세요.
 * Created by jeongjinhong on 2022. 08. 05..
 */
fun GithubResponse.mapToDomain(): Github = Github(
    this.fullName,
    this.description
)