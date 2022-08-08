package camp.nextstep.edu.github.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.repository.Repository
import camp.nextstep.edu.github.domain.GetRepositoriesUseCase
import camp.nextstep.edu.github.ui.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getRepositoriesUseCase: GetRepositoriesUseCase,
) : ViewModel() {

    private val _repositories = MutableLiveData<List<Repository>>()
    val repositories: LiveData<List<Repository>>
        get() = _repositories

    private val _loadingFailed = SingleLiveEvent<Boolean>()
    val loadingFailed: LiveData<Boolean>
        get() = _loadingFailed

    fun fetchRepositories() = viewModelScope.launch {
        getRepositoriesUseCase()
            .onSuccess { _repositories.value = it }
            .onFailure { _loadingFailed.value = true }
    }
}
