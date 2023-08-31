package com.nextstep.edu.data

import com.google.common.truth.Truth.assertThat
import com.nextstep.edu.data.model.RepositoryResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

@ExperimentalCoroutinesApi
class GithubServiceTest {

    private val testDispatcher = StandardTestDispatcher()
    private val testScope = TestScope(testDispatcher)

    private lateinit var server: MockWebServer
    private lateinit var service: GithubService

    @BeforeEach
    fun setup() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(server.url(""))
            .build()
            .create(GithubService::class.java)
    }

    @Test
    fun `getRepositories 호출시 결과의 첫번째는 mojombo grit의 정보이다`() = testScope.runTest {
        // given : githubRepositories.json 파일이 주어졌을 때
        val response = MockResponse()
            .setBody(File("src/test/resources/githubRepositories.json").readText())
        server.enqueue(response)

        // when : getRepositories() 를 요청하면
        val actual = service.getRepositories()

        // then : 결과의 첫번째는 mojombo/grit의 정보이다.
        val expected = RepositoryResponse(
            fullName = "mojombo/grit",
            description = "**Grit is no longer maintained. Check out libgit2/rugged.** Grit gives you object oriented read/write access to Git repositories via Ruby."
        )
        assertThat(actual[0]).isEqualTo(expected)
    }

    @Test
    fun `getRepositories 호출시 결과의 두번째의 wycats merb-core의 정보이다`() = testScope.runTest {
        // given : githubRepositories.json 파일이 주어졌을 때
        val response = MockResponse()
            .setBody(File("src/test/resources/githubRepositories.json").readText())
        server.enqueue(response)

        // when : getRepositories() 를 요청하면
        val actual = service.getRepositories()

        // then : 결과의 두번째는 wycats/merb-core의 정보이다.
        val expected = RepositoryResponse(
            fullName = "wycats/merb-core",
            description = "Merb Core: All you need. None you don't."
        )
        assertThat(actual[1]).isEqualTo(expected)
    }
}
