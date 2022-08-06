package camp.nextstep.edu.github.domain

interface GitRepoRepository {
    suspend fun getGitRepos(): List<GitRepo>
}