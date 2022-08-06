package camp.nextstep.edu.github.domain

import javax.inject.Inject

/**
 * 클래스에 대한 간단한 설명이나 참고 url을 남겨주세요.
 * Created by jeongjinhong on 2022. 08. 06..
 */

class GetGithubDatasUseCase @Inject constructor(
    private val githubRepository: GithubRepository
) {
    suspend fun execute(): List<Github> = githubRepository.getGithub()
}