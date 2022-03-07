package camp.nextstep.edu.github

import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.model.Repository
import camp.nextstep.edu.github.domain.usecase.GithubRepositoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val gieHubUseCase: GithubRepositoryUseCase
) : BaseViewModel() {

    val items = MutableStateFlow<List<Repository>>(emptyList())

    fun loadRepository() {
        gieHubUseCase().handleResultWithState {
            viewModelScope.launch {
                items.emit(it.items)
            }
        }
    }
}
