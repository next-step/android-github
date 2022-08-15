package camp.nextstep.edu.github

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.GithubRepoRepository
import camp.nextstep.edu.github.domain.GithubRepositoryResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val githubRepoRepository: GithubRepoRepository) :
    ViewModel() {
    private val _repositoryResponseList: MutableLiveData<List<GithubRepositoryUiModel>> =
        MutableLiveData()
    val repositoryResponseList: LiveData<List<GithubRepositoryUiModel>>
        get() = _repositoryResponseList

    fun loadRepositoryResponse() {
        viewModelScope.launch {
            _repositoryResponseList.value =
                githubRepoRepository.getRepositories()
                    .map(GithubRepositoryResponse::toUiModel)
        }
    }
}