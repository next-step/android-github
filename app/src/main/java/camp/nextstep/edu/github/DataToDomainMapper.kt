package camp.nextstep.edu.github

interface DomainModelToUiModelMapper<T> {
    fun toUiModel(): T
}
