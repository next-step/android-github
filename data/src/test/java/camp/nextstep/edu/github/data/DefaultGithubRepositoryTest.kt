package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.Repository
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DefaultGithubRepositoryTest {

    private lateinit var githubService: GithubService
    private lateinit var githubRepository: DefaultGithubRepository

    @BeforeEach
    fun setUp() {
        githubService = mockk(relaxed = true)
        githubRepository = DefaultGithubRepository(
            githubService = githubService,
            repositoryMapper = RepositoryMapper()
        )
    }

    @Test
    fun `전체 Repository 리스트를 불러올 수 있다`() = runBlocking {
        // given
        val entity = RepositoryDto(
            fullName = "wisemuji",
            description = "This is test description"
        )
        coEvery { githubService.getRepositories() } returns listOf(entity)

        // when
        val actual: List<Repository> = githubRepository.getRepositories()

        // then
        assertThat(actual).containsExactly(
            Repository(
                fullName = "wisemuji",
                description = "This is test description"
            )
        )
        coVerify { githubService.getRepositories() }
    }
}
