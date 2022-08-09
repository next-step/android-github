package camp.nextstep.edu.github.domain

import camp.nextstep.edu.github.domain.repository.GithubRepository
import camp.nextstep.edu.github.domain.repository.Repository
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GetRepositoriesUseCaseTest {

    private lateinit var repository: GithubRepository
    private lateinit var getRepositoriesUseCase: GetRepositoriesUseCase

    @BeforeEach
    fun setUp() {
        repository = mockk(relaxed = true)
        getRepositoriesUseCase = GetRepositoriesUseCase(repository)
    }

    @Test
    fun `Github Repository 리스트를 받아올 수 있다`() = runBlocking {
        // given
        val entity = Repository(
            fullName = "wisemuji",
            description = "This is test description"
        )
        coEvery { repository.getRepositories() } returns listOf(entity)

        // when
        val actual: List<Repository> = repository.getRepositories()

        // then
        assertThat(actual).containsExactly(
            Repository(
                fullName = "wisemuji",
                description = "This is test description"
            )
        )
        coVerify { repository.getRepositories() }
    }
}
