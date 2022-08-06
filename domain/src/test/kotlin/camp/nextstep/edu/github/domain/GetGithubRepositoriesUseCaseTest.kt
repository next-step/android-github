package camp.nextstep.edu.github.domain

import camp.nextstep.edu.github.domain.model.GithubRepositoryInfo
import camp.nextstep.edu.github.domain.repository.GithubRepository
import camp.nextstep.edu.github.domain.usecase.GetGithubRepositoriesUseCase
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@ExperimentalCoroutinesApi
class GetGithubRepositoriesUseCaseTest {
    private lateinit var getGithubRepositoriesUseCase: GetGithubRepositoriesUseCase
    private val dispatcher = StandardTestDispatcher()
    private val scope = TestScope(dispatcher)

    @BeforeEach
    fun setup() {
        val githubRepository: GithubRepository = mockk()
        getGithubRepositoriesUseCase = GetGithubRepositoriesUseCase(githubRepository)
    }

    @Test
    fun `깃허브 repository들의 정보를 가져온다`() = scope.runTest {
        coEvery { getGithubRepositoriesUseCase.invoke() } returns (listOf(
            GithubRepositoryInfo(fullName = "AnKyungMoo", description = "developer"),
            GithubRepositoryInfo(fullName = "Bran", description = "app developer"),
        ))

        assertThat(getGithubRepositoriesUseCase()[0].fullName).isEqualTo("AnKyungMoo")
        assertThat(getGithubRepositoriesUseCase()[0].description).isEqualTo("developer")
    }
}
