package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepository
import io.mockk.coVerify
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class GithubRepositoryImplTest {

    private lateinit var repository: GithubRepository

    @BeforeEach
    fun setUp() {
        repository = GithubRepositoryImpl()
    }

    @Test
    fun `깃헙 repository 리스트를 불러온다`() = runBlocking {
        coVerify {
            repository.fetchGithubRepos()
        }
    }
}