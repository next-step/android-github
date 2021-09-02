package com.nextstep.edu.github.data

import com.nextstep.edu.github.data.remote.GithubRemoteDataSource
import com.nextstep.edu.github.domain.GithubRepository
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class GithubRepositoryImplTest {

    private val githubRemoteDataSource: GithubRemoteDataSource = mockk(relaxed = true)
    private lateinit var repository: GithubRepository

    @BeforeEach
    fun setup() {
        repository = GithubRepositoryImpl(githubRemoteDataSource = githubRemoteDataSource)
    }

    @Test
    fun `깃헙 레파지토리 리스트를 불러옵니다`() = runBlocking {
        repository.fetchRepositories()
        coVerify {
            githubRemoteDataSource.fetchRepositories()
        }
    }
}
