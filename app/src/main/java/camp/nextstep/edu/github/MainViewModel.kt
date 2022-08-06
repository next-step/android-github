package camp.nextstep.edu.github

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import camp.nextstep.edu.github.data.GitRepo
import camp.nextstep.edu.github.data.GithubService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val githubService: GithubService
) : ViewModel() {
    val repos: LiveData<List<GitRepo>> = liveData { emit(githubService.getRepositories()) }
}
