package camp.nextstep.edu.github

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.GithubRepo
import camp.nextstep.edu.github.domain.GithubRepositories
import camp.nextstep.edu.github.domain.GithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val githubRepository: GithubRepository
): ViewModel() {

    private val _gitRepo: MutableLiveData<GithubRepositories> = MutableLiveData()
    val gitRepo: LiveData<GithubRepositories> = _gitRepo

    fun fetchGithubRepo() = viewModelScope.launch {
        _gitRepo.value = githubRepository.getRepo()
    }
}