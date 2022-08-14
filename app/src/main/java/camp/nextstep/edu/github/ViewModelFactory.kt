package camp.nextstep.edu.github

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import camp.nextstep.edu.github.data.Injector

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val newViewModel =
            when (modelClass) {
                MainViewModel::class.java -> createMainViewModel()
                else -> IllegalArgumentException()
            } as T
        return newViewModel
    }

    private fun createMainViewModel(): MainViewModel =
        MainViewModel(githubRepoRepository = Injector.provideGithubRepository())
}