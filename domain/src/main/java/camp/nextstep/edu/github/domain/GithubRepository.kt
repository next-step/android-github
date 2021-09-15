package camp.nextstep.edu.github.domain

interface GithubRepository {
    suspend fun loadRepos(): Result<List<Repo>>
}
