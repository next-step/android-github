package camp.nextstep.edu.github.data

interface GitRepoRepository {
    suspend fun getGitRepos(): List<GitRepo>
}