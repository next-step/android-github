package camp.nextstep.edu.github.data

interface MapperToDomain<T> {
    fun toDomain(): T
}