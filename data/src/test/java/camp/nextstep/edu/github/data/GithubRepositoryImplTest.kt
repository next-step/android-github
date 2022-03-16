package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepoModel
import camp.nextstep.edu.github.domain.GithubRepository
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class GithubRepositoryImplTest {

    private lateinit var repository: GithubRepository


    @BeforeEach
    fun setUp() {
        repository = GithubRepositoryImpl(mockk(relaxed = true))
    }

    @Test
    fun `깃헙 repository 리스트 호출을 성공한다`() = runBlocking {
        // given
        // when
        val mockResult = Result.success(
            listOf(
                GithubRepoModel("testName1", "testDesc1"),
                GithubRepoModel("testName2", "testDesc2")
            )
        )

        coEvery { repository.fetchGithubRepos() } returns mockResult

        // then
        assertThat(mockResult.isSuccess).isTrue()
        val repos = mockResult.getOrNull()
        assertThat(repos).isNotNull()
    }

    @Test
    internal fun `'깃헙 repository 리스트 호출에 실패한다`() {
        // given
        // when
        val mockResult = Result.failure<List<GithubRepoModel>>(Exception())
        coEvery { repository.fetchGithubRepos() } returns mockResult

        // then
        assertThat(mockResult.isSuccess).isFalse()
    }
}