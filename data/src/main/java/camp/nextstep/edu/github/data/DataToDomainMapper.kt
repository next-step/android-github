package camp.nextstep.edu.github.data

interface DataToDomainMapper<T> {
    fun toDomain(): T
}