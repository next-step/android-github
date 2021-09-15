package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.remote.response.RepoResponse
import com.google.common.truth.Expect
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class GithubRepositoryImplTest {

    private lateinit var repository: GithubRepositoryImpl
    private lateinit var dataSource: GithubDataSource

    @get:Rule
    val expect: Expect = Expect.create()

    @Before
    fun setUp() {
        dataSource = mockk(relaxed = true)
        repository = GithubRepositoryImpl(dataSource)
    }


    @Test
    fun `레파지토리 리스트 호출시, 정상적으로 받아와야한다`() = runBlocking {
        // given
        val repos = listOf(
            RepoResponse(1, "name1", "testDesc1"),
            RepoResponse(2, "name2", "testDesc2"),
            RepoResponse(3, "name3", "testDesc3"),
        )
        coEvery { dataSource.loadRepos() } returns repos


        // when
        val result = repository.loadRepos()

        // then
        expect.that(result.isSuccess).isTrue()
        val list = result.getOrNull()
        expect.that(list).isNotNull()
        expect.that(list).isEqualTo(repos.map(RepoResponse::toEntity))
    }


    @Test
    fun `레파지토리 리스트 호출시, 에러가 발생하면, fail을 리턴해야한다`() = runBlocking {
        // given
        val expectedException = Exception("Error")
        coEvery { dataSource.loadRepos() } throws expectedException

        // when
        val result = repository.loadRepos()

        // then
        expect.that(result.isFailure).isTrue()
        expect.that(result.exceptionOrNull()).isEqualTo(expectedException)
    }

}
