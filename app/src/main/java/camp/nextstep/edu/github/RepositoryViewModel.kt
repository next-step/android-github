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

    init {
        viewModelScope.launch {
            _repositories.value = getRepositoryUseCase.invoke()
        }
    }
}
