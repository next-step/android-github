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
    
    private val _githubRepositoryInfoLiveData = MutableLiveData<List<GitHubRepositoryInfo>>()
    val githubRepositoryInfoLiveData: LiveData<List<GitHubRepositoryInfo>> get() = _githubRepositoryInfoLiveData

    init {
        getGithubRepositoryInfo()
    }

    private fun getGithubRepositoryInfo() {
        viewModelScope.launch {
            _githubRepositoryInfoLiveData.value = gitHubRepository.getGitHubRepositoryInfo()
        }
    }
}