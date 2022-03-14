package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepository
import camp.nextstep.edu.github.domain.Github
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GithubRepositoryImplTest {
    private lateinit var repository: GithubRepository

    @Before
    fun setUp() {
        repository = mockk(relaxed = true)
    }

    @Test
    fun `깃헙 repository 리스트 통신을 성공한다`() = runBlocking {

        // when
        val actual = Result.success(
            listOf(
                Github("name", "description")
            )
        )
        coEvery { repository.getRepository() } returns actual

        // then
        assertThat(actual.isSuccess).isTrue()
    }

    @Test
    fun `깃헙 repository 리스트 통신을 실패한다`() = runBlocking {

        // when
        val actual = Result.failure<List<Github>>(Exception())
        coEvery { repository.getRepository() } returns actual

        // then
        assertThat(actual.isSuccess).isFalse()
    }
}