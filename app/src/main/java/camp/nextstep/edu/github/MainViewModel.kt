package camp.nextstep.edu.github

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.GetGithubRepositoryUsecase
import camp.nextstep.edu.github.domain.RepositoryVO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val useCase: GetGithubRepositoryUsecase) : ViewModel() {

    private val _items: MutableLiveData<List<RepositoryVO>> = MutableLiveData()
    val items: LiveData<List<RepositoryVO>>
        get() = _items


    private val _errorMsg: SingleLiveEvent<ErrorEvent> = SingleLiveEvent()
    val errorMsg: LiveData<ErrorEvent>
        get() = _errorMsg

    fun getGitHubRepository() {
        viewModelScope.launch {
            val result = useCase.invoke()
            if (result.isSuccess) {
                _items.value = result.getOrNull()
            } else {
                _errorMsg.value = ErrorEvent.NetworkError
            }
        }
    }
}