package camp.nextstep.edu.github

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val gitHubRepository: GitHubRepository,
) : ViewModel() {

    private val _githubRepositoryInfo = MutableLiveData<List<GitHubRepositoryInfo>?>()
    val githubRepositoryInfo: LiveData<List<GitHubRepositoryInfo>?> get() = _githubRepositoryInfo

    suspend fun getGithubRepositoryInfo() {
        _githubRepositoryInfo.value = gitHubRepository.getGitHubRepositoryInfo()
    }
}