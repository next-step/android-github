package camp.nextstep.edu.github

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.network.GithubDataSource
import camp.nextstep.edu.github.ui.UiStatus
import camp.nextstep.edu.github.ui.main.GithubMainSideEffect
import camp.nextstep.edu.github.ui.main.GithubMainState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class GithubRepositoriesViewModel @Inject constructor(
    private val dataSource: GithubDataSource
) : ContainerHost<GithubMainState, GithubMainSideEffect>, ViewModel() {
    override val container = container<GithubMainState, GithubMainSideEffect>(GithubMainState())

    init {
        fetchRepositories()
    }

    private fun fetchRepositories() {
        intent {
            reduce { state.copy(status = UiStatus.Loading) }
            viewModelScope.launch {
                runCatching {
                    async {
                        val repositories = dataSource.fetchRepositories()
                        reduce {
                            state.copy(
                                status = UiStatus.Success,
                                repositories = repositories
                            )
                        }
                    }
                }.getOrElse {
                    reduce { state.copy(status = UiStatus.Failed("로딩 실패")) }
                }
            }
        }
    }
}
