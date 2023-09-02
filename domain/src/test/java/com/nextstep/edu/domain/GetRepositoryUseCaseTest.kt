package com.nextstep.edu.domain

import com.google.common.truth.Truth.assertThat
import com.nextstep.edu.domain.model.Repository
import com.nextstep.edu.domain.repository.RemoteRepository
import com.nextstep.edu.domain.usecase.GetRepositoryUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetRepositoryUseCaseTest {

    private lateinit var getRepositoryUseCase: GetRepositoryUseCase
    private val testDispatcher = StandardTestDispatcher()
    private val testScope = TestScope(testDispatcher)

    @BeforeEach
    fun setup() {
        val remoteRepository: RemoteRepository = mockk()
        getRepositoryUseCase = GetRepositoryUseCase(remoteRepository)
    }

    @Test
    fun `getRepositoryUseCase의 결과가 빈리스트일 수 있다`() = testScope.runTest {
        // given : getRepositoryUseCase()의 결과 설정
        coEvery {
            getRepositoryUseCase()
        } returns Result.success(emptyList())

        // when : getRepositoryUseCase() 메서드 실행
        getRepositoryUseCase()
            .onSuccess {
                // then : 결과는 빈리스트 이다.
                val actual = it
                assertThat(actual).isEqualTo(emptyList<Repository>())
            }
    }

    @Test
    fun `getRepositoryUseCase의 결과인 리스트의 첫번째 fullName은 Hwang-Gyuil이다`() = testScope.runTest {
        // given : getRepositoryUseCase()의 결과 설정
        coEvery {
            getRepositoryUseCase()
        } returns Result.success(listOf(Repository(id = 0, fullName = "Hwang-Gyuil", description = "hi")))

        // when : getRepositoryUseCase() 메서드 실행
        getRepositoryUseCase()
            .onSuccess {
                // then : 첫번째 인덱스의 fullName은 Hwang-Gyuil이다.
                val actual = it[0].fullName
                assertThat(actual).isEqualTo("Hwang-Gyuil")
            }
    }

    @Test
    fun `getRepositoryUseCase의 크기는 설정한 사이즈 값이다`() = testScope.runTest {
        // given : getRepositoryUseCase()의 결과 설정
        coEvery {
            getRepositoryUseCase()
        } returns Result.success(
            listOf(
                Repository(id = 0, fullName = "Hwang-Gyuil", description = "hi"),
                Repository(id = 0, fullName = "duru.hi", description = "hihi")
            )
        )

        // when : getRepositoryUseCase() 메서드 실행
        getRepositoryUseCase()
            .onSuccess {
                // then : 결과의 크기는 2이다.
                val actual = it.size
                assertThat(actual).isEqualTo(2)
            }
    }
}
