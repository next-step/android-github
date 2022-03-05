package camp.nextstep.edu.github.di

import camp.nextstep.edu.github.ui.GithubAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class ViewModule {
    @Provides
    @ActivityScoped
    fun provideChampionAdapter(): GithubAdapter = GithubAdapter()
}
