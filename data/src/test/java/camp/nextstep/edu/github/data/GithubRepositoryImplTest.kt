package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepo
import camp.nextstep.edu.github.domain.GithubRepositories
import camp.nextstep.edu.github.domain.GithubRepository
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import io.mockk.*
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
internal class GithubRepositoryImplTest {

    lateinit var githubRepository: GithubRepository
    lateinit var githubApiService: GithubApiService

    @Before
    fun setUp() {
        githubApiService = mockk()
        githubRepository = GithubRepositoryImpl(githubApiService)
    }

    @Test
    fun 저장소를_불러오는_메서드를_호출했을_때_GithubApiService의_호출되는_메서드를_확인한다() = runTest {
        //given
        coEvery { githubApiService.repositories() } returns emptyList()

        //when
        githubRepository.getRepo()

        //then
        coVerify { githubApiService.repositories() }
    }

    @Test
    fun 저장소를_불러오는_메소드를_호출했을_때_반환되는_값을_확인한다() = runTest {
        //given
        val expected =  GithubRepositories(
            listOf(
                GithubRepo(-1, "test", "test description")
            )
        )
        coEvery { githubApiService.repositories() } returns listOf(GithubRepoResponse(-1, "test", "test description"))

        //when
        val actual = githubRepository.getRepo()

        //then
        coVerify { githubApiService.repositories() }
        assertThat(actual.list).isEqualTo(expected.list)
    }
}