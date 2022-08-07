package camp.nextstep.edu.github

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.repository.GithubRepository
import camp.nextstep.edu.github.mapper.toItem
import camp.nextstep.edu.github.model.RepositoryItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val githubRepository: GithubRepository
) : ViewModel() {

    private val _repositoryListFlow = MutableStateFlow<List<RepositoryItem>>(emptyList())
    val repositoryListFlow = _repositoryListFlow.asStateFlow()

    fun loadRepositoryList() {
        viewModelScope.launch {
            githubRepository.fetchRepositoryList()
                .onSuccess { repositoryList ->
                    _repositoryListFlow.value = repositoryList.map { it.toItem() }
                }
        }
    }
}
