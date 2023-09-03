/**
 * @author Daewon on 02,September,2023
 *
 */

package camp.nextstep.edu.github

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.model.RepositoryItem
import camp.nextstep.edu.github.domain.repository.GithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GithubViewModel @Inject constructor(
    private val githubRepository: GithubRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private val _uiEffect = Channel<UiEffect>()
    val uiEffect = _uiEffect.receiveAsFlow()

    init {
        getGithubRepositories()
    }

    private fun getGithubRepositories() {
        viewModelScope.launch {
            githubRepository.getRepositories()
                .onSuccess { result ->
                    _uiState.value = UiState.Success(result)
                }.onFailure {
                    _uiState.value = UiState.Error(it.message.orEmpty())
                    _uiEffect.send(UiEffect.ShowToast(it.message.orEmpty()))
                }
        }
    }
}

sealed interface UiState {
    object Loading : UiState
    data class Success(val repositories: List<RepositoryItem>) : UiState
    data class Error(val message: String) : UiState
}

sealed interface UiEffect {
    data class ShowToast(val message: String) : UiEffect
}
