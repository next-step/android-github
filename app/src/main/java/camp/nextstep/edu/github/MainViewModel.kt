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
class MainViewModel @Inject constructor(private val githubRepoRepository: GithubRepoRepository) : ViewModel() {
    private val _repositoryData: MutableLiveData<List<GithubRepositoryResponse>> = MutableLiveData()
    val repositoryData: LiveData<List<GithubRepositoryResponse>>
        get() = _repositoryData

    fun loadRepositoryData() {
        viewModelScope.launch {
            _repositoryData.value = githubRepoRepository.getRepositories()
        }
    }
}