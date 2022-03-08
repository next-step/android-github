package camp.nextstep.edu.github.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.GetGithubRepositoriesUseCase
import camp.nextstep.edu.github.domain.model.NetworkState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val githubRepositoriesUseCase: GetGithubRepositoriesUseCase
) : ViewModel() {

    private val _eventFlow = MutableStateFlow<NetworkState>(NetworkState.Loading)
    val stateFlow = _eventFlow.asStateFlow()
    val sharedFlow = _eventFlow.asSharedFlow()

    private val _networkLiveEvent = SingleLiveEvent<NetworkState>()
    val networkLiveEvent: LiveData<NetworkState>
        get() = _networkLiveEvent

    fun getGithubRepositories() = viewModelScope.launch {
        githubRepositoriesUseCase().collect {
            _eventFlow.emit(it)
            _networkLiveEvent.value = it
        }
    }
}
