package camp.nextstep.edu.github.data.di

import camp.nextstep.edu.github.data.datasource.GithubRemoteDataSource
import camp.nextstep.edu.github.data.repository.GithubRepositoryImpl
import camp.nextstep.edu.github.domain.repository.GithubRepository

object RepositoryInjector {
    fun provideRepositoryInjector(githubRemoteDataSource: GithubRemoteDataSource): GithubRepository =
        GithubRepositoryImpl(githubRemoteDataSource)
}