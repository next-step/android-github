package camp.nextstep.edu.github

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.GithubRepository
import camp.nextstep.edu.github.domain.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val networkRepository: NetworkRepository
) : ViewModel() {

    private val _repositories = MutableStateFlow<UiState<List<GithubRepository>>>(UiState.Loading)
    val repositories = _repositories.asStateFlow()

    fun fetchRepositories() = viewModelScope.launch {
        if (_repositories.value !is UiState.Success) {
            networkRepository.getGithubRepositories()
                .onSuccess { _repositories.emit(UiState.Success(it)) }
                .onFailure { _repositories.emit(UiState.Error(it)) }
        }
    }

}