package camp.nextstep.edu.github.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.GetGithubRepositoriesUseCase
import camp.nextstep.edu.github.domain.model.NetworkState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    githubRepositoriesUseCase: GetGithubRepositoriesUseCase
) : ViewModel() {

    val networkState: StateFlow<NetworkState> = githubRepositoriesUseCase().stateIn(
        scope = viewModelScope,
        started = WhileSubscribed(5000L),
        initialValue = NetworkState.Loading
    )
}
