package camp.nextstep.edu.github

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import camp.nextstep.edu.github.domain.GithubSearchRepository

class MainViewModelFactory(
    private val searchRepository: GithubSearchRepository,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(searchRepository) as T
        } else {
            throw IllegalArgumentException()
        }
    }
}
