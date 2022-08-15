package camp.nextstep.edu.github

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.GitHubRepository
import camp.nextstep.edu.github.domain.GitHubRepositoryItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: GitHubRepository
) : ViewModel() {
    private val _gitHubRepositoryItemList = MutableLiveData<List<GitHubRepositoryItem>>()
    val gitHubRepositoryItemList: LiveData<List<GitHubRepositoryItem>>
        get() = _gitHubRepositoryItemList

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String>
        get() = _errorMessage

    fun getGitHubRepositoryList() {
        viewModelScope.launch {
            val response = repository.getGitHubRepositoryList()
            if (response.isSuccess) {
                _gitHubRepositoryItemList.value = response.getOrNull()
            } else {
                _errorMessage.value = response.exceptionOrNull().toString()
            }
        }
    }
}