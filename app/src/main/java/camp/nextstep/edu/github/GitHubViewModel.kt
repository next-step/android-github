package camp.nextstep.edu.github

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.model.GitHub
import camp.nextstep.edu.github.domain.usecase.FetchGitHubUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GitHubViewModel @Inject constructor(
    private val fetchGitHubUseCase: FetchGitHubUseCase
) : ViewModel() {
    private val _githubs = MutableLiveData<List<GitHub>>()
    val githubs: LiveData<List<GitHub>> = _githubs

    fun fetch() = viewModelScope.launch {
        fetchGitHubUseCase()
            .onSuccess { _githubs.value = it }
    }
}
