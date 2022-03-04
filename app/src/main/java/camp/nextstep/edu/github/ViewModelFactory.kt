package camp.nextstep.edu.github

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import camp.nextstep.edu.github.data.di.Injector

class ViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            MainViewModel::class.java -> createMainViewModel()
            else -> throw IllegalArgumentException()
        } as T
    }

    private fun createMainViewModel(): MainViewModel {
        val mainUseCase = Injector.providesGithubUseCase()
        return MainViewModel(mainUseCase)
    }
}
