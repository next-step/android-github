package com.nextstep.edu.github.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class RepositoriesFetchUseCaseTest {

    private val githubRepository: GithubRepository = mockk(relaxed = true)
    private lateinit var useCase: RepositoriesFetchUseCase

    @BeforeEach
    fun setup() {
        useCase = RepositoriesFetchUseCase(githubRepository = githubRepository)
    }

    @Test
    fun `깃헙 레파지토리 리스트를 불러옵니다`() = runBlocking {
        useCase.execute()
        coVerify {
            githubRepository.fetchRepositories()
        }
    }
}
