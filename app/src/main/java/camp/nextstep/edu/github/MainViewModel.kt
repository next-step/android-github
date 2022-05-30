package camp.nextstep.edu.github

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.model.GithubRepoModel
import camp.nextstep.edu.github.domain.usecase.GithubRepositoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val githubRepositoryUseCase: GithubRepositoryUseCase
): ViewModel() {
    private val _githubList = MutableLiveData<List<GithubRepoModel>>(emptyList())
    val githubList: LiveData<List<GithubRepoModel>>
        get() = _githubList

    private val _showErrorMessage = MutableLiveData<Event<String>>()
    val showErrorMessage: LiveData<Event<String>>
        get() = _showErrorMessage

    fun requestGithubRepository() = viewModelScope.launch {
        githubRepositoryUseCase().onSuccess { githubRepoList ->
            _githubList.value = githubRepoList
        }.onFailure { error ->
            _showErrorMessage.value = Event(error.message.toString())
        }
    }
}