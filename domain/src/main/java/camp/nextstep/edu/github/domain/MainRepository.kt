package camp.nextstep.edu.github.domain

interface MainRepository {
    suspend fun getGitHubRepositories() : List<GitHubRepository>
}
