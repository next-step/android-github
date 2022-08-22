package camp.nextstep.edu.github

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.usecase.GetGithubStorageUseCase
import camp.nextstep.edu.github.model.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getGithubStorageUseCase: GetGithubStorageUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow<UIState>(UIState.Loading)
    val uiState = _uiState.asStateFlow()

    fun getGithubStorage() = viewModelScope.launch {
        _uiState.value = UIState.Loading
        _uiState.value = getGithubStorageUseCase().fold(
            onSuccess = { storages -> UIState.Success(storages) },
            onFailure = { throwable -> UIState.Error(throwable) }
        )
    }
}