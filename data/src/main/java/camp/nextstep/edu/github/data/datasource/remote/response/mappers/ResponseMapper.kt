package camp.nextstep.edu.github.data.datasource.remote.response.mappers

internal interface ResponseMapper<R, D> {

    fun mapToDomain(response: R): D
}