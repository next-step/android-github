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

    private val _repositoryState = MutableLiveData<RepositoriesState>()
    val repositorySate
        get(): LiveData<RepositoriesState> = _repositoryState

    init {
        fetchRepositories()
    }

    private fun fetchRepositories() {
        _repositoryState.value = RepositoriesState.Loading

        job = viewModelScope.launch {
            val repository = withContext(ioDispatcher) {
                return@withContext gitHubRepository.getRepositories()
            }
            repository
                .onSuccess { repositories -> _repositoryState.value = RepositoriesState.Success(repositories) }
                .onFailure { throwable ->
                    when (throwable) {
                        Error.NetworkUnavailable -> _repositoryState.value = RepositoriesState.Failure(Error.NetworkUnavailable)
                        else -> _repositoryState.value = RepositoriesState.Failure(throwable)
                    }
                }
        }
    }
}