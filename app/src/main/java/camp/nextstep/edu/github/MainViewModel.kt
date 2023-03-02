package camp.nextstep.edu.github

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val gitHubRepository: GitHubRepository,
) : ViewModel() {

    private val _githubRepositoryInfo = MutableLiveData<List<GitHubRepositoryInfo>>()
    val githubRepositoryInfo: LiveData<List<GitHubRepositoryInfo>> get() = _githubRepositoryInfo

    fun getGithubRepositoryInfo() {
        viewModelScope.launch {
            _githubRepositoryInfo.value = gitHubRepository.getGitHubRepositoryInfo()
        }
    }
}