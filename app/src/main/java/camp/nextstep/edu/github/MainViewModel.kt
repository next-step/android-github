package camp.nextstep.edu.github

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.GithubRepoRepository
import camp.nextstep.edu.github.domain.GithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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

    private val _errorMessage: MutableLiveData<String> = MutableLiveData()
    val errorMessage: LiveData<String>
        get() = _errorMessage

    fun loadRepositoryResponse() =
        viewModelScope.launch {
            _isLoadingVisible.value = true
            githubRepoRepository.getRepositories()
                .onSuccess {
                    it.map(GithubRepository::toUiModel)
                        .also(_repositoryResponseList::setValue)
                }.onFailure {
                    _errorMessage.value = it.message ?: ""
                }
            _isLoadingVisible.value = false
        }
}