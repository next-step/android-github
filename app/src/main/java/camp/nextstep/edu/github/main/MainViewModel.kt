package camp.nextstep.edu.github.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.usecase.GetGithubRepositoriesUseCase
import camp.nextstep.edu.github.main.model.UiRepository
import camp.nextstep.edu.github.main.model.mappers.UiRepositoryMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getGithubRepositoriesUseCase: GetGithubRepositoriesUseCase,
    private val uiRepositoryMapper: UiRepositoryMapper
) : ViewModel() {

    private val _repositoryList = MutableStateFlow(emptyList<UiRepository>())
    val repositoryList = _repositoryList.asStateFlow()

    fun getGithubRepositories() = getGithubRepositoriesUseCase()
        .map(uiRepositoryMapper::mapToView)
        .onEach(::successGetGithubRepositories)
        .catch { failGetGithubRepositories(it) }
        .launchIn(viewModelScope)

    private fun successGetGithubRepositories(repositoryList: List<UiRepository>) {
        _repositoryList.value = repositoryList
    }

    private fun failGetGithubRepositories(throwable: Throwable) {

    }
}