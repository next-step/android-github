package camp.nextstep.edu.github

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.dodobest.data.GithubRepositoryImpl
import com.github.dodobest.data.retrofit.RetrofitManager
import com.github.dodobest.domain.usecase.GetRepositoriesUseCase

class GithubViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when (modelClass) {
            GithubViewModel::class.java -> createGithubViewModel()
            else -> throw IllegalArgumentException()
        } as T
    }

    private fun createGithubViewModel(): GithubViewModel {
        val retrofitManager = RetrofitManager()
        val githubRepositoryImpl = GithubRepositoryImpl(retrofitManager)
        val getRepositoriesUseCase = GetRepositoriesUseCase(githubRepositoryImpl)
        return GithubViewModel(getRepositoriesUseCase)
    }
}