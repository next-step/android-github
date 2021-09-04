package com.nextstep.edu.github.data.remote

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class GithubRemoteDataSourceImplTest {

    private val githubService: GithubService = mockk(relaxed = true)
    private lateinit var dataSource: GithubRemoteDataSource

    @BeforeEach
    fun setup() {
        dataSource = GithubRemoteDataSourceImpl(githubService = githubService)
    }

    @Test
    fun `깃헙 레파지토리 리스트를 불러옵니다`() = runBlocking {
        dataSource.fetchRepositories()
        coVerify {
            githubService.fetchRepositories()
        }
    }
}
