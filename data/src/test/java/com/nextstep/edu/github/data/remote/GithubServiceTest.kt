package com.nextstep.edu.github.data.remote

import com.nextstep.edu.github.domain.entity.RepositoryItem
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.File
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

internal class GithubServiceTest {

    private val mockServer = MockWebServer()
    private lateinit var service: GithubService

    @BeforeEach
    fun setup() {
        service = Retrofit
            .Builder()
            .baseUrl(mockServer.url(""))
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi
                        .Builder()
                        .add(KotlinJsonAdapterFactory())
                        .build()
                )
            )
            .build()
            .create(GithubService::class.java)
    }

    @Test
    fun `깃헙 레파지토리 리스트를 불러옵니다`() = runBlocking {
        val response = MockResponse()
            .setBody(File("src/test/resources/repositories.json").readText())
        mockServer.enqueue(response)

        val actual = service.fetchRepositories()

        val expected = listOf(
            RepositoryItem(
                fullName = "mojombo/grit",
                description = "**Grit is no longer maintained. Check out libgit2/rugged.** Grit gives you object oriented read/write access to Git repositories via Ruby."
            ),
            RepositoryItem(
                fullName = "wycats/merb-core",
                description = "Merb Core: All you need. None you don't."
            )
        )
        assertEquals(expected, actual)
    }
}
