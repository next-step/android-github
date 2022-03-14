package camp.nextstep.edu.github

import androidx.lifecycle.LiveData
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

    private val _loadingEvent = SingleLiveEvent<Boolean>()
    val loadingEvent: LiveData<Boolean> get() = _loadingEvent

    init {
        fetchGithubRepos()
    }

    private fun fetchGithubRepos() = viewModelScope.launch {
        _loadingEvent.value = true

        val result = githubRepository.fetchGithubRepos()
        if (result.isSuccess) {
            _reposEvent.postValue(
                result.getOrElse { emptyList() }
            )
            _loadingEvent.postValue(false)
            return@launch
        }

        _loadingEvent.postValue(false)
    }
}