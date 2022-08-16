package camp.nextstep.edu.github.data

internal interface DataToDomainMapper<T> {
    fun toDomain(): T
}