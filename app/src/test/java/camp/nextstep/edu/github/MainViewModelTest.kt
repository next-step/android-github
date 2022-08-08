package camp.nextstep.edu.github

import camp.nextstep.edu.github.data.GitRepoRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class MainViewModelTest {

    private lateinit var viewModel: MainViewModel
    private lateinit var gitRepoRepository: GitRepoRepository

    @BeforeEach
    fun setUp() {
        gitRepoRepository = mockk()
        viewModel = MainViewModel(gitRepoRepository)
    }

    @Test
    fun `정상 Repo`() = runBlocking {
        // given
        coEvery { gitRepoRepository.getGitRepos() } returns listOf()

        // when
        viewModel.repos.get

        // then
    }

}