package camp.nextstep.edu.github

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.GetRepositoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class GithubRepositoriesViewModel @Inject constructor(
    private val getRepositoryUseCase: GetRepositoriesUseCase
) : ViewModel() {

    var uiState by mutableStateOf<GithubRepositoriesUiState>(GithubRepositoriesUiState.Empty)
        private set

    var uiEffect by mutableStateOf<GithubRepositoriesUiEffect>(GithubRepositoriesUiEffect.NotLoading)
        private set

    fun onEvent(event: GithubRepositoriesUiEvent) = when (event) {
        GithubRepositoriesUiEvent.LoadRepositories -> eventLoadRepositories()
    }

    private fun eventLoadRepositories() {
        getRepositoryUseCase()
            .map(GithubRepositoriesUiState::LoadedGithubRepositories)
            .catch { sendUiStateLoadError() }
            .onStart { startLoading() }
            .onCompletion { stopLoading() }
            .onEach(::updateUiState)
            .launchIn(viewModelScope)
    }

    private fun sendUiStateLoadError() {
        updateUiState(GithubRepositoriesUiState.LoadError)
    }

    private fun startLoading() {
        updateUiEffect(GithubRepositoriesUiEffect.Loading)
    }

    private fun stopLoading() {
        updateUiEffect(GithubRepositoriesUiEffect.NotLoading)
    }

    private fun updateUiState(newUiState: GithubRepositoriesUiState) {
        uiState = newUiState
    }

    private fun updateUiEffect(newUiEffect: GithubRepositoriesUiEffect) {
        uiEffect = newUiEffect
    }
}