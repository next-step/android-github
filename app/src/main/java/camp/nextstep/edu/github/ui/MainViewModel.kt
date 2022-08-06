package camp.nextstep.edu.github.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.usecase.GetGithubRepositoriesUseCase
import camp.nextstep.edu.github.model.GithubRepoUiModel
import camp.nextstep.edu.github.model.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getGithubRepositoriesUseCase: GetGithubRepositoriesUseCase
): ViewModel() {
    private val _repos = MutableLiveData<List<GithubRepoUiModel>>()
    val repos: LiveData<List<GithubRepoUiModel>>
        get() = _repos

    fun getRepositories() {
        viewModelScope.launch {
            _repos.value = getGithubRepositoriesUseCase.invoke().map { it.toUiModel() }
        }
    }
}
