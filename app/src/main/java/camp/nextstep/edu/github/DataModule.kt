package camp.nextstep.edu.github

import camp.nextstep.edu.github.remote.Injector
import camp.nextstep.edu.github.data.GitRepoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideGitRepoRepository(): GitRepoRepository {
        return Injector.getGitRepoRepository()
    }
}