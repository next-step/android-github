package camp.nextstep.edu.github

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.model.GithubStorage
import camp.nextstep.edu.github.domain.model.NetworkState
import camp.nextstep.edu.github.domain.usecase.GetGithubStorageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getGithubStorageUseCase: GetGithubStorageUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<NetworkState>(NetworkState.Loading)
    val uiState = _uiState.asSharedFlow()

    private val _githubStorages = MutableStateFlow<List<GithubStorage>>(emptyList())
    val githubStorages = _githubStorages.asStateFlow()

    private val _loadingEvent = MutableStateFlow(false)
    val loadingEvent = _loadingEvent.asStateFlow()

    private val _errorEvent = MutableSharedFlow<Throwable>()
    val errorEvent = _errorEvent.asSharedFlow()

    fun updateGithubStorage(githubStorages: List<GithubStorage>) {
        _githubStorages.value = githubStorages
    }

    fun updateLoadingEvent(isLoading: Boolean) = viewModelScope.launch {
        _loadingEvent.emit(isLoading)
    }

    fun updateErrorEvent(error: Throwable) = viewModelScope.launch {
        _errorEvent.emit(error)
    }

    fun getGithubStorage() = viewModelScope.launch {
        _uiState.value = NetworkState.Loading
        _uiState.value = getGithubStorageUseCase.invoke()
    }
}