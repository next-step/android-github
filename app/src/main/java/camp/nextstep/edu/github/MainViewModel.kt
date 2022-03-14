package camp.nextstep.edu.github

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.error.Error
import camp.nextstep.edu.github.domain.repository.GitHubRepository
import kotlinx.coroutines.*

class MainViewModel(
    private val gitHubRepository: GitHubRepository,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
) : ViewModel() {
    private var job: Job? = null

    private val _repositoryState = MutableLiveData<State>()
    val repositorySate
        get(): LiveData<State> = _repositoryState

    init {
        fetchRepositories()
    }

    private fun fetchRepositories() {
        _repositoryState.value = State.Loading

        job = viewModelScope.launch {
            val repository = withContext(ioDispatcher) {
                return@withContext gitHubRepository.getRepositories()
            }
            repository
                .onSuccess { repositories -> _repositoryState.value = State.Success(repositories) }
                .onFailure { throwable ->
                    when (throwable) {
                        Error.NetworkUnavailable -> _repositoryState.value = State.Failure(Error.NetworkUnavailable)
                        else -> _repositoryState.value = State.Failure(throwable)
                    }
                }
        }
    }
}