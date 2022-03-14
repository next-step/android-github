package camp.nextstep.edu.github

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.data.Injector
import camp.nextstep.edu.github.domain.GithubRepoModel
import camp.nextstep.edu.github.domain.GithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class GithubViewModel(
    private val githubRepository: GithubRepository = Injector.provideGithubRepository()
) : ViewModel() {

    private val _reposEvent = SingleLiveEvent<List<GithubRepoModel>>()
    val reposEvent: LiveData<List<GithubRepoModel>> get() = _reposEvent

    init {
        fetchGithubRepos()
    }

    private fun fetchGithubRepos() = viewModelScope.launch {
        val result = githubRepository.fetchGithubRepos()
        if (result.isSuccess) {
            _reposEvent.postValue(
                result.getOrElse { emptyList() }
            )
        }
    }
}