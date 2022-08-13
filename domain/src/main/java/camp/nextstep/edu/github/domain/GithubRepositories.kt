package camp.nextstep.edu.github.domain

data class GithubRepositories(private val repoList: List<GithubRepo>) {
    fun list() = repoList.toList()
}