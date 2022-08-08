package camp.nextstep.edu.github

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.GithubRepository
import camp.nextstep.edu.github.domain.Repositories
import kotlinx.coroutines.launch

/**
 * Created by link.js on 2022. 08. 08..
 */
class RepositoryViewModel(
    private val githubRepository: GithubRepository,
) : ViewModel() {

    private val _repositories = MutableLiveData<Repositories>()
    val repositories: LiveData<Repositories>
        get() = _repositories


    fun loadRepositories() {
        viewModelScope.launch {
            _repositories.value = githubRepository.getRepositories()
        }
    }
}