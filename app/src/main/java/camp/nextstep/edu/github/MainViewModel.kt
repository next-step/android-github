package camp.nextstep.edu.github

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.GithubRepoRepository
import camp.nextstep.edu.github.domain.GithubRepository
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

    private val _isLoadingVisible: MutableLiveData<Boolean> = MutableLiveData(false)
    val isLoadingVisible: LiveData<Boolean>
        get() = _isLoadingVisible

    private val _isErrorVisible: MutableLiveData<Boolean> = MutableLiveData(false)
    val isErrorVisible: LiveData<Boolean>
        get() = _isErrorVisible

    private val _errorMessage: MutableLiveData<String> = MutableLiveData()
    val errorMessage: LiveData<String>
        get() = _errorMessage

    fun loadRepositoryResponse() =
        viewModelScope.launch {
            _isLoadingVisible.value = true
            val repoRepositoryResult = githubRepoRepository.getRepositories()
            _isLoadingVisible.value = false
            if (repoRepositoryResult.isSuccess) {
                repoRepositoryResult.getOrNull()
                    ?.map(GithubRepository::toUiModel)
                    .also(_repositoryResponseList::setValue)
                return@launch
            }
            _isErrorVisible.value = true
            _errorMessage.value = repoRepositoryResult.exceptionOrNull()?.message ?: ""
        }
}