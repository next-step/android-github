package camp.nextstep.edu.github.domain

class GithubRepositories(
    private val list: List<GithubRepo> = emptyList()
) {
    fun list() = list
}