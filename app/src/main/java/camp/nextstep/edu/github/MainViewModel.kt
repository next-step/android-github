package camp.nextstep.edu.github

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.GithubRepoRepository
import camp.nextstep.edu.github.domain.GithubRepositoryData
import kotlinx.coroutines.launch

class MainViewModel(private val githubRepoRepository: GithubRepoRepository) : ViewModel() {
    private val _repositoryData: MutableLiveData<List<GithubRepositoryData>> = MutableLiveData()
    val repositoryData: LiveData<List<GithubRepositoryData>>
        get() = _repositoryData

    fun loadRepositoryData() {
        viewModelScope.launch {
            _repositoryData.value = githubRepoRepository.getRepositories()
        }
    }
}