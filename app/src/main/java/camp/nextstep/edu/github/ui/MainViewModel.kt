package camp.nextstep.edu.github.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.usecase.GetGithubRepositoriesUseCase
import camp.nextstep.edu.github.model.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getGithubRepositoriesUseCase: GetGithubRepositoriesUseCase
): ViewModel() {
    fun getRepositories() {
        viewModelScope.launch {
            getGithubRepositoriesUseCase.invoke().map { it.toUiModel() }
        }
    }
}
