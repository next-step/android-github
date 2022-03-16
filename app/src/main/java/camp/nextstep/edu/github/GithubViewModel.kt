package camp.nextstep.edu.github

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.GithubRepoModel
import camp.nextstep.edu.github.domain.GithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GithubViewModel @Inject constructor(
    private val githubRepository: GithubRepository
) : ViewModel() {

    private val _reposEvent = SingleLiveEvent<List<GithubRepoModel>>()
    val reposEvent: LiveData<List<GithubRepoModel>> get() = _reposEvent

    private val _loadingState = MutableLiveData<Boolean>()
    val loadingState: LiveData<Boolean> get() = _loadingState

    init {
        fetchGithubRepos()
    }

    private fun fetchGithubRepos() = viewModelScope.launch {
        _loadingState.value = true

        githubRepository.fetchGithubRepos()
            .onSuccess {
                _reposEvent.postValue(it)
            }

        _loadingState.postValue(false)
    }
}