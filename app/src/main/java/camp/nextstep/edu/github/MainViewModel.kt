package camp.nextstep.edu.github

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.entity.GithubRepo
import camp.nextstep.edu.github.domain.repository.GithubRepoRepository
import camp.nextstep.edu.github.utils.ToastMessage
import kotlinx.coroutines.launch

/**
 * Created By Malibin
 * on 9월 13, 2021
 */

class MainViewModel(
    private val githubReposRepository: GithubRepoRepository,
) : ViewModel() {

    private val _toastMessage = MutableLiveData<ToastMessage>()
    val toastMessage: LiveData<ToastMessage> = _toastMessage

    private val _githubRepos = MutableLiveData<List<GithubRepo>>()
    val githubRepos: LiveData<List<GithubRepo>> = _githubRepos

    fun loadGithubRepos(userName: String) = viewModelScope.launch {
        githubReposRepository.getRepositoriesOf(userName)
            .onSuccess { _githubRepos.value = it }
            .onFailure { _toastMessage.value = ToastMessage.StringValue(it.message.orEmpty()) }
    }
}
