package camp.nextstep.edu.github

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.model.Repository
import camp.nextstep.edu.github.domain.repository.GithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val githubRepository: GithubRepository
) : ViewModel() {

    private val _repositoryListFlow = MutableStateFlow<List<Repository>>(emptyList())
    val repositoryListFlow = _repositoryListFlow.asStateFlow()

    fun loadRepositoryList() {
        viewModelScope.launch {
            githubRepository.fetchRepositoryList()
                .onSuccess {
                    _repositoryListFlow.value = it
                }
        }
    }
}
