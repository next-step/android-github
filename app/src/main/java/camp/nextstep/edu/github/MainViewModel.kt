package camp.nextstep.edu.github

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.GithubSearchRepository
import camp.nextstep.edu.github.domain.model.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val gitHubSearchRepository: GithubSearchRepository
) : ViewModel() {
    private val _repositories = MutableLiveData<List<Repository>>()
    private val repositories: LiveData<List<Repository>>
        get() = _repositories

    fun searchRepositories(query: String) = viewModelScope.launch(Dispatchers.IO) {
        _repositories.value = gitHubSearchRepository.searchGitHubs()

    }
}
