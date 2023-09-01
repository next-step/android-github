/**
 * @author Daewon on 02,September,2023
 *
 */

package camp.nextstep.edu.github.data.di

import camp.nextstep.edu.github.data.network.DefaultNetworkRepository
import camp.nextstep.edu.github.domain.repository.NetworkRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface DataModule {

    @Singleton
    @Binds
    fun bindNetworkRepository(
        networkRepositoryImpl: DefaultNetworkRepository
    ): NetworkRepository
}
