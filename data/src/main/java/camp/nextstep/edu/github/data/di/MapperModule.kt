package camp.nextstep.edu.github.data.di

import camp.nextstep.edu.github.data.datasource.remote.response.mappers.ResponseRepositoryMapper

internal object MapperModule {

    val responseRepositoryMapper = provideResponseRepositoryMapper()

    private fun provideResponseRepositoryMapper(): ResponseRepositoryMapper = ResponseRepositoryMapper()
}