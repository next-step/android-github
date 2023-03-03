package com.example.data

import com.example.data.retrofit.RetrofitNetworkApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.create
import java.io.File
import com.google.common.truth.Truth.assertThat

class RetrofitNetworkApiTest {
    private lateinit var server: MockWebServer
    private lateinit var service: RetrofitNetworkApi

    @Before
    fun setUp() {
        val contentType = "application/json".toMediaType()
        val json = Json {
            ignoreUnknownKeys = true
        }
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(json.asConverterFactory(contentType))
            .build().create()
    }

    @Test
    fun `빈 배열 JSON이 들어오면 빈 배열을 반환한다`() = runBlocking {
        // given
        val response = MockResponse().setBody("""[]""")
        server.enqueue(response)
        // when
        val actual = service.getRepositories()

        // then
        assertThat(actual.isEmpty()).isTrue()
    }

    @Test
    fun `일반적인 JSON이 들어오면 정상적인 모델을 반환한다`() = runBlocking {
        // given
        val response = MockResponse().setBody(
            File("src/test/resources/normal_response.json").readText()
        )
        server.enqueue(response)
        // when
        val actual = service.getRepositories()

        // then
        assertThat(actual.size).isEqualTo(1)
        assertThat(actual[0].fullName).isEqualTo("mojombo/grit")
        assertThat(actual[0].description).isEqualTo("**Grit is no longer maintained. Check out libgit2/rugged.** Grit gives you object oriented read/write access to Git repositories via Ruby.")
    }

    @Test
    fun `필드가 null인 JSON이 들어오면 null이 된다`() = runBlocking {
        // given
        val response = MockResponse().setBody(
            File("src/test/resources/lack_response.json").readText()
        )
        server.enqueue(response)
        // when
        val actual = service.getRepositories()

        // then
        assertThat(actual.size).isEqualTo(1)
        assertThat(actual[0].fullName).isEqualTo(null)
        assertThat(actual[0].description).isEqualTo(null)

    }

    @Test
    fun `필드가 없는 JSON이 들어오면 emptyString이 된다`() = runBlocking {
        // given
        val response = MockResponse().setBody(
            File("src/test/resources/lack_response2.json").readText()
        )
        server.enqueue(response)
        // when
        val actual = service.getRepositories()

        // then
        assertThat(actual.size).isEqualTo(1)
        assertThat(actual[0].fullName).isEqualTo("")
        assertThat(actual[0].description).isEqualTo("")

    }
}
