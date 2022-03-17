package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.exception.HttpResponseFailureException
import camp.nextstep.edu.github.data.network.GitHubService
import camp.nextstep.edu.github.data.network.response.RepositoriesItem
import camp.nextstep.edu.github.domain.error.Error
import camp.nextstep.edu.github.domain.model.GitHubRepositoryData
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import retrofit2.Response
import java.net.UnknownHostException
import java.net.http.HttpTimeoutException

internal class GitHubRepositoryImplTest {
    lateinit var gitHubRepository: GitHubRepositoryImpl
    lateinit var gitHubService: GitHubService
    @BeforeEach
    fun setUp() {
        gitHubService = mockk()
        gitHubRepository = GitHubRepositoryImpl(gitHubService)
    }

    @DisplayName("정상적인(200) 응답이 있을 경우 Repository 리스트를 가지고 온다")
    @Test
    fun getRepositoriesTest(): Unit = runBlocking {
        coEvery { gitHubService.getRepositories() } returns Response.success(
            listOf(
                RepositoriesItem("defunkt/starling", ""),
                RepositoriesItem("defunkt/starling", null),
                RepositoriesItem("wycats/merb-more", "Merb More: The Full Stack. Take what you need; leave what you don't.")
            )
        )

        val actual: List<GitHubRepositoryData> = gitHubRepository.getRepositories().getOrNull()!!

        assertThat(actual).containsExactly(
            GitHubRepositoryData("defunkt/starling", ""),
            GitHubRepositoryData("defunkt/starling", ""),
            GitHubRepositoryData("wycats/merb-more", "Merb More: The Full Stack. Take what you need; leave what you don't.")
        )
    }

    @DisplayName("UnknownHostException 이 발생할 때 NetworkUnavailable Error 가 Result 에 전달된다")
    @Test
    fun unknownHostExceptionTest() = runBlocking {
        coEvery { gitHubService.getRepositories() } throws UnknownHostException()

        val actual = gitHubRepository.getRepositories().exceptionOrNull()!!

        assertThat(actual).isInstanceOf(Error.NetworkUnavailable.javaClass)
    }

    @DisplayName("HttpResponseFailureException 이 발생할 때 NetworkUnavailable Error 가 Result 에 전달된다")
    @Test
    fun  httpStatusExceptionTest() = runBlocking {
        coEvery { gitHubService.getRepositories() } throws HttpResponseFailureException(400, "Problems parsing JSON")

        val actual = gitHubRepository.getRepositories().exceptionOrNull()!!

        assertThat(actual).isInstanceOf(Error.NetworkUnavailable.javaClass)
    }

    @DisplayName("기타 Exception 이 발생할 때  Result 에 기타 Exception 이 전달된다")
    @Test
    fun  etcExceptionTest() = runBlocking {
        coEvery { gitHubService.getRepositories() } throws HttpTimeoutException("timeout!")

        val actual = gitHubRepository.getRepositories().exceptionOrNull()!!

        assertThat(actual).isInstanceOf(HttpTimeoutException::class.java)
    }


}