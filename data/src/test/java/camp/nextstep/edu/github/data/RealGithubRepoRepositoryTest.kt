package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.remote.response.GithubRepoResponse
import camp.nextstep.edu.github.data.remote.service.GithubService
import camp.nextstep.edu.github.domain.entity.GithubRepo
import camp.nextstep.edu.github.domain.exception.NotFoundUserException
import camp.nextstep.edu.github.domain.repository.GithubRepoRepository
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import retrofit2.Response

/**
 * Created By Malibin
 * on 9월 09, 2021
 */

internal class RealGithubRepoRepositoryTest {

    private lateinit var githubService: GithubService
    private lateinit var githubRepoRepository: GithubRepoRepository

    @BeforeEach
    fun setUp() {
        githubService = mockk(relaxed = true)
        githubRepoRepository = RealGithubRepoRepository(githubService)
    }

    @Test
    fun `유저 이름에 맞는 Github Repo 목록을 가져온다`(): Unit = runBlocking {
        // given
        val githubReposResponse = listOf(
            GithubRepoResponse(0, "name1", "fullName1", "description1"),
            GithubRepoResponse(1, "name2", "fullName2", null),
        )
        val reposResponse = Response.success(200, githubReposResponse)
        coEvery { githubService.getUserRepos("malibinYun") } returns reposResponse

        val expectedGithubRepos = listOf(
            GithubRepo(0, "fullName1", "description1"),
            GithubRepo(1, "fullName2", ""),
        )

        // when
        val githubReposResult = githubRepoRepository.getRepositoriesOf("malibinYun")

        // then
        val actualGithubRepos = githubReposResult.getOrThrow()
        assertAll(
            { assertThat(githubReposResult.isSuccess).isTrue() },
            { assertThat(actualGithubRepos).containsExactlyElementsIn(expectedGithubRepos) },
        )

    }

    @Test
    fun `유저는 존재하지만 Repo가 없는 경우 빈 목록을 반환한다`() = runBlocking {
        // given
        val reposResponse = Response.success(200, emptyList<GithubRepoResponse>())
        coEvery { githubService.getUserRepos("malibinYun") } returns reposResponse

        // when
        val githubReposResult = githubRepoRepository.getRepositoriesOf("malibinYun")
        val actualGithubRepos = githubReposResult.getOrThrow()

        // then
        assertAll(
            { assertThat(githubReposResult.isSuccess).isTrue() },
            { assertThat(actualGithubRepos).isEmpty() },
        )
    }

    @Test
    fun `존재하지 않는 유저의 Repo를 조회하면 NotFoundUserException이 발생한다`() = runBlocking {
        // given
        val userNotFoundResponse = "{}".toResponseBody("application/json".toMediaTypeOrNull())
        val reposResponse = Response.error<List<GithubRepoResponse>>(404, userNotFoundResponse)
        coEvery { githubService.getUserRepos("malibinYun") } returns reposResponse

        // when
        val githubReposResult = githubRepoRepository.getRepositoriesOf("malibinYun")
        val actualException = githubReposResult.exceptionOrNull()

        // then
        assertAll(
            { assertThat(githubReposResult.isFailure).isTrue() },
            { assertThat(actualException).isInstanceOf(NotFoundUserException::class.java) },
        )
    }
}
