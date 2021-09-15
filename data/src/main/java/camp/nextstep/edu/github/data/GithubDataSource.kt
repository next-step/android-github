package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.remote.response.RepoResponse

interface GithubDataSource {
    suspend fun loadRepos(): List<RepoResponse>
}
