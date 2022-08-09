package camp.nextstep.edu.github

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.data.GitRepo
import camp.nextstep.edu.github.data.GitRepoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val gitRepoRepository: GitRepoRepository
) : ViewModel() {

    private val _viewEvent: SingleLiveEvent<ViewEvent> = SingleLiveEvent()
    val viewEvent: LiveData<ViewEvent> = _viewEvent

    private val _repos: MutableLiveData<List<GitRepo>> = MutableLiveData()
    val repos: LiveData<List<GitRepo>> = _repos

    fun fetchGitRepos() {
        viewModelScope.launch {
            try {
                _repos.value = gitRepoRepository.getGitRepos()
            } catch (throwable: Throwable) {
                _repos.value = emptyList()
                _viewEvent.value = ViewEvent.GitRepoLoadingFailure
            }
        }
    }

    sealed class ViewEvent {
        object GitRepoLoadingFailure : ViewEvent()
    }
}
