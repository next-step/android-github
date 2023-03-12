package camp.nextstep.edu.github

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.GithubSearchRepository
import camp.nextstep.edu.github.domain.model.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val gitHubSearchRepository: GithubSearchRepository
) : ViewModel() {
    private val _repositories = MutableLiveData<List<Repository>>()
    val repositories: LiveData<List<Repository>>
        get() = _repositories

    fun searchRepositories() = viewModelScope.launch {
        val repositories = gitHubSearchRepository.searchGitHubs()
        _repositories.postValue(repositories)

    }
}
