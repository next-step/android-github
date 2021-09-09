package camp.nextstep.edu.github.data.source

import camp.nextstep.edu.github.domain.entity.GithubRepo

internal interface GithubReposSource {

    suspend fun getGithubReposOf(userName: String): List<GithubRepo>
}