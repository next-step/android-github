package camp.nextstep.edu.github.data.dto

interface DataToDomainMapper<T> {
    fun toDomainModel(): T
}
