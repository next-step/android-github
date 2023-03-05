package camp.nextstep.edu.github

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.RepositoryResource
import com.example.domain.usecase.GetRepositoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepositoryViewModel @Inject constructor(
    val getRepositoryUseCase: GetRepositoryUseCase
) : ViewModel() {

    private val _repositories = MutableLiveData<List<RepositoryResource>>(emptyList())
    val repositories: LiveData<List<RepositoryResource>>
        get() = _repositories

    private val _exception = MutableLiveData("")
    val exception: LiveData<String>
        get() = _exception

    init {
        viewModelScope.launch {
            kotlin.runCatching { getRepositoryUseCase.invoke() }
                .onSuccess { _repositories.value = it }
                .onFailure {
                    _exception.value = it.message ?: ""
                }
        }
    }
}
