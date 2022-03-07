package camp.nextstep.edu.github.domain.model

data class Repositories(private val items: List<Repository>) {

    fun getItems() = items
}