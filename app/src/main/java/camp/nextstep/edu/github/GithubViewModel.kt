/**
 * @author Daewon on 02,September,2023
 *
 */

package camp.nextstep.edu.github

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.model.GithubRepository
import camp.nextstep.edu.github.domain.repository.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GithubViewModel @Inject constructor(
    private val networkRepository: NetworkRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    init {
        getGithubRepositories()
    }

    private fun getGithubRepositories() {
        viewModelScope.launch {
            networkRepository.getRepositories()
                .onSuccess { result ->
                    _uiState.value = UiState.Success(result)
                }.onFailure {
                    _uiState.value = UiState.Error(it.message.orEmpty())
                }
        }
    }
}

sealed interface UiState {
    object Loading : UiState
    data class Success(val repositories: List<GithubRepository>) : UiState
    data class Error(val message: String) : UiState
}
