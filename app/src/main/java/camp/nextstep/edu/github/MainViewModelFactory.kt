package camp.nextstep.edu.github

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import camp.nextstep.edu.github.domain.repository.GitHubRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class MainViewModelFactory(
    private val gitHubRepository: GitHubRepository,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return when(modelClass) {
           MainViewModel::class.java -> MainViewModel(gitHubRepository, ioDispatcher)
           else -> throw IllegalArgumentException()
       } as T
    }
}