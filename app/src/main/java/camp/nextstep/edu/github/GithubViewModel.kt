/**
 * @author Daewon on 02,September,2023
 *
 */

package camp.nextstep.edu.github

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.model.GithubRepository
import camp.nextstep.edu.github.domain.repository.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GithubViewModel @Inject constructor(
    private val networkRepository: NetworkRepository
) : ViewModel() {

    private val _repositories = MutableStateFlow<List<GithubRepository>>(emptyList())
    val repositories: StateFlow<List<GithubRepository>> = _repositories.asStateFlow()

    init {
        getGithubRepositories()
    }

    private fun getGithubRepositories() {
        viewModelScope.launch {
            networkRepository.getRepositories().onSuccess { result ->
                _repositories.value = result
            }
        }
    }
}
