package camp.nextstep.edu.github

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class GithubViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when (modelClass) {
            GithubViewModel::class.java -> createGithubViewModel()
            else -> throw IllegalArgumentException()
        } as T
    }

    private fun createGithubViewModel(): GithubViewModel {
        return GithubViewModel()
    }
}