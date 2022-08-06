package camp.nextstep.edu.github.data

internal interface Mapper<E, D> {

    fun toDomain(entity: E): D

    fun toEntity(domain: D): E
}
