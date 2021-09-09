package camp.nextstep.edu.github.data.remote.service

import camp.nextstep.edu.github.domain.entity.GithubRepo
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.io.File

@ExperimentalCoroutinesApi
internal class GithubServiceTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var githubService: GithubService

    @BeforeEach
    fun setUp() {
        mockWebServer = MockWebServer()
        githubService = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(mockWebServer.url(""))
            .build()
            .create()
    }

    @Test
    fun `Github 유저의 Repository 목록을 가져올 수 있다`() = runBlocking {
        // given
        val responseJson = File("src/test/resources/getUserReposSuccessResponse.json").readText()
        val response = MockResponse().setBody(responseJson)
        mockWebServer.enqueue(response)

        val expectedRepos = listOf(
            GithubRepo(
                id = 259960586,
                fullName = "malibinYun/ACNH-Wiki",
                description = ""
            ),
            GithubRepo(
                id = 262033249,
                fullName = "malibinYun/ACNH_data_collect_rearrange",
                description = "동숲 데이터 크롤링, 가공하는 파일들 관리 귀찮아서 업로드"
            )
        )

        // when
        val actualResponse = githubService.getUserRepos("malibinyun")

        // then
        val actualRepos = actualResponse.body()?.map { it.toGithubRepo() }
        assertAll(
            { assertThat(actualResponse.isSuccessful).isTrue() },
            { assertThat(actualResponse.code()).isEqualTo(200) },
            { assertThat(actualRepos).containsExactlyElementsIn(expectedRepos) },
        )
    }

    @Test
    fun `없는 유저의 Repository는 조회할 수 없다`() = runBlocking {
        // given
        val responseJson = File("src/test/resources/getUserReposNotFoundUserResponse.json").readText()
        val response = MockResponse()
            .setResponseCode(404)
            .setBody(responseJson)
        mockWebServer.enqueue(response)

        // when
        val actualResponse = githubService.getUserRepos("malibinyun")

        // then
        assertAll(
            { assertThat(actualResponse.isSuccessful).isFalse() },
            { assertThat(actualResponse.code()).isEqualTo(404) },
            { assertThat(actualResponse.body()).isNull() },
        )
    }
}
