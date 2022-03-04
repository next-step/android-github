package camp.nextstep.edu.github

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.GetGithubRepositoriesUseCase
import camp.nextstep.edu.github.domain.model.Github
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val githubRepositoriesUseCase: GetGithubRepositoriesUseCase
) : ViewModel() {

    private val _githubRepositories = MutableStateFlow<List<Github>>(emptyList())
    val githubRepositories: SharedFlow<List<Github>>
        get() = _githubRepositories
    private val _networkState = MutableSharedFlow<Boolean>()
    val networkState: SharedFlow<Boolean>
        get() = _networkState

    fun getGithubRepositories() = viewModelScope.launch {
        githubRepositoriesUseCase().onSuccess {
            _networkState.emit(true)
            _githubRepositories.emit(it)
        }.onFailure {
            _networkState.emit(false)
        }
    }
}
