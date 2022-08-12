package com.nextstep.edu.github

import camp.nextstep.edu.github.data.GithubApi
import camp.nextstep.edu.github.data.GithubRepositoryResponse
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File

@OptIn(ExperimentalCoroutinesApi::class)
internal class NetworkTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var githubApi: GithubApi

    @BeforeEach
    fun setUp() {
        mockWebServer = MockWebServer()
        githubApi = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(mockWebServer.url(""))
            .build()
            .create(GithubApi::class.java)
    }

    @Test
    fun `깃헙 저장소를 불러오는데 빈 값이 불러와질 때 테스트`() = runTest {
        // given
        val response = MockResponse().setBody(File("src/test/resources/empty.json").readText())
        mockWebServer.enqueue(response)

        // when
        val actual = githubApi.getGithubRepositories()

        // then
        val expected = listOf<GithubRepositoryResponse>()
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `깃헙 저장소 목록을 받아온다`() = runTest {
        // given
        val response = MockResponse().setBody(File("src/test/resources/response.json").readText())
        mockWebServer.enqueue(response)

        // when
        val actual = githubApi.getGithubRepositories()

        // then
        val expected = listOf(
            GithubRepositoryResponse(
                fullName = "choiyounho",
                description = "test"
            )
        )
        assertThat(actual).isEqualTo(expected)
    }

}