package camp.nextstep.edu.github.main

import camp.nextstep.edu.github.domain.model.Repositories
import camp.nextstep.edu.github.domain.usecase.GetGithubRepositoriesUseCase
import camp.nextstep.edu.github.main.model.mappers.UiRepositoryMapper
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class MainViewModelTest {

    private val dispatcher = StandardTestDispatcher()

    private val getGithubRepositoriesUseCase = mockk<GetGithubRepositoriesUseCase>(relaxed = true)
    private val uiRepositoryMapper = UiRepositoryMapper()
    private lateinit var viewModel: MainViewModel

    @BeforeEach
    internal fun setUp() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel(getGithubRepositoriesUseCase, uiRepositoryMapper)
    }

    @AfterEach
    internal fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    @DisplayName("")
    fun test() = runTest {
        val mockRepositories = Repositories(mockk(relaxed = true))
        val expected = uiRepositoryMapper.mapToView(mockRepositories)
        coEvery { getGithubRepositoriesUseCase() } answers { flow { emit(mockRepositories) } }

        // when
        viewModel.getGithubRepositories().join()

        // then
        val actual = viewModel.repositoryList.value
        assertThat(actual).isEqualTo(expected)
    }
}