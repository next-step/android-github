package camp.nextstep.edu.github

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.vo.RepositoryItemVo
import com.nextstep.edu.github.domain.RepositoriesFetchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repositoriesFetchUseCase: RepositoriesFetchUseCase
): ViewModel() {

    private val _repositories = MutableLiveData<List<RepositoryItemVo>>()
    val repositories: LiveData<List<RepositoryItemVo>> get() = _repositories

    private val _error = MutableLiveData<Throwable>()
    val error: LiveData<Throwable> get() = _error

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _error.value = throwable
    }

    fun fetchRepositories() = viewModelScope.launch(coroutineExceptionHandler) {
        repositoriesFetchUseCase
            .execute()
            .onSuccess {
                _repositories.value = it.map(RepositoryItemVo::fromDto)
            }
            .onFailure {
                _error.value = it
            }
    }

}
