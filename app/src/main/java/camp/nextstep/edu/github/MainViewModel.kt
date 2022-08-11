package camp.nextstep.edu.github

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import camp.nextstep.edu.github.domain.model.GitHubRepos
import camp.nextstep.edu.github.domain.usecase.GetGitHubReposUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getGitHubReposUseCase: GetGitHubReposUseCase
) : ViewModel() {
    private val _gitHubRepos : MutableLiveData<GitHubRepos> = MutableLiveData(GitHubRepos(emptyList()))
    val gitHubRepos : LiveData<GitHubRepos> = _gitHubRepos

    suspend fun loadGitHubRepos() {
        _gitHubRepos.value = getGitHubReposUseCase.invoke()
    }

}
