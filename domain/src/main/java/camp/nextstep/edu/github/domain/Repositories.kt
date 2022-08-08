package camp.nextstep.edu.github.domain

data class Repositories(private val repoList: List<Repo>) {
    fun list() = repoList.toList()
}