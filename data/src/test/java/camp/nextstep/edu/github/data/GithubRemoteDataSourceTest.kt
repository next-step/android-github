package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.datasource.GithubRemoteDataSource
import camp.nextstep.edu.github.data.datasource.GithubRemoteDataSourceImpl
import camp.nextstep.edu.github.data.model.GithubStorageResponse
import camp.nextstep.edu.github.data.service.GithubAPI
import camp.nextstep.edu.github.domain.model.GithubStorage
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class GithubRemoteDataSourceTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var mockWebServer: MockWebServer
    private lateinit var githubAPI: GithubAPI
    private lateinit var githubRemoteDataSource: GithubRemoteDataSource

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        mockWebServer = MockWebServer()

        githubAPI = Retrofit.Builder()
            .baseUrl(mockWebServer.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubAPI::class.java)

        githubRemoteDataSource = GithubRemoteDataSourceImpl(
            githubAPI,
            mainDispatcherRule.testDispatcher
        )
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun 깃헙_저장소가_비어있으면_비어있는_리스트가_보여진다() = runTest {
        // given
        val response =
            MockResponse().setBody(File("src/test/resources/repositories/empty.json").readText())
        mockWebServer.enqueue(response)

        // when
        val actual = githubRemoteDataSource.getRepositories()
        advanceUntilIdle()

        // then
        val expected = Result.success(emptyList<GithubStorageResponse>())
        assertThat(actual).isEqualTo(expected)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun 깃헙_저장소에_값이_있으면_모든_값이_보여진다() = runTest {
        // given
        val response =
            MockResponse().setBody(File("src/test/resources/repositories/200.json").readText())
        mockWebServer.enqueue(response)

        // when
        val actual = githubRemoteDataSource.getRepositories()
        advanceUntilIdle()

        // then
        val expected = Result.success(listOf(GithubStorage("KimSangmin", "test")))
        assertThat(actual).isEqualTo(expected)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun 깃헙_저장소에서_값을_불러오는데_실패하면_isFailure가_true로_반환한다() = runTest {
        // given
        val response =
            MockResponse().setResponseCode(400)
        mockWebServer.enqueue(response)

        // when
        val actual = githubRemoteDataSource.getRepositories().isFailure
        advanceUntilIdle()

        // then
        assertThat(actual).isEqualTo(true)
    }
}