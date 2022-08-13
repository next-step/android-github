package camp.nextstep.edu.github

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.GithubRepositoryUseCase
import camp.nextstep.edu.github.domain.Repositories
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by link.js on 2022. 08. 08..
 */

@HiltViewModel
class RepositoryViewModel @Inject constructor(
    private val githubRepositoryUseCase: GithubRepositoryUseCase,
) : ViewModel() {

    private val _repositories = MutableLiveData<Repositories>()
    val repositories: LiveData<Repositories>
        get() = _repositories


    fun loadRepositories() {
        viewModelScope.launch {
            _repositories.value = githubRepositoryUseCase.invoke()
        }
    }
}