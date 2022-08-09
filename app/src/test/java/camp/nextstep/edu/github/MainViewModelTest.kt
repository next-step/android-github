package camp.nextstep.edu.github

import camp.nextstep.edu.github.domain.model.Repository
import camp.nextstep.edu.github.domain.repository.GithubRepository
import camp.nextstep.edu.github.model.RepositoryItem
import com.google.common.truth.Truth.assertThat
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @MockK lateinit var githubRepository: GithubRepository
    @InjectMockKs private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxed = true)
    }

    @Test
    fun `레포지토리 목록을 요청하면 레포지토리 목록이 노출된다`() {
        // given
        val sampleList = listOf(
            Repository("fullName1", "description1"),
            Repository("fullName2", null),
        )
        coEvery {
            githubRepository.fetchRepositoryList()
        } returns Result.success(sampleList)

        // when
        viewModel.loadRepositoryList()

        // then
        val expected = listOf(
            RepositoryItem("fullName1", "description1"),
            RepositoryItem("fullName2", "null"),
        )
        val actual = viewModel.repositoryListFlow.value
        assertThat(actual).isEqualTo(expected)
    }
}
