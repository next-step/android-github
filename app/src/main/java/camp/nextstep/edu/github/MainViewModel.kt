package camp.nextstep.edu.github

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.GithubRepository
import camp.nextstep.edu.github.domain.NetworkRepository
import camp.nextstep.edu.github.domain.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val networkRepository: NetworkRepository
) : ViewModel() {

    private val _repositories = MutableStateFlow<UiState<List<GithubRepository>>>(UiState.Loading)
    val repositories = _repositories.asStateFlow()

    fun fetchRepositories() = viewModelScope.launch {
        networkRepository.getGithubRepositories().collect { uiState: UiState<List<GithubRepository>> ->
            when (uiState) {
                is UiState.Success -> _repositories.emit(uiState)
                is UiState.Error -> _repositories.emit(uiState)
                is UiState.Loading -> _repositories.emit(uiState)
            }
        }
    }

}