package camp.nextstep.edu.github.data

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.Test

internal class GithubServiceTest {

    private val service = GithubService()

    @Test
    fun `full_name, descroption을 받아온다`() = runBlocking {
        // given
        val server = MockWebServer()
        // TODO sinseungmin 2022/08/04: 서버 구현체를 너무 많이 알고있는 코드 아님?
        server.enqueue(MockResponse().setBody("""
            [{"full_name": "greedy0110", "description": "hello world"}]
        """.trimIndent()))
        server.start()

        // when
        val actual = service.getRepositories()

        // then
        val expected = listOf(
            GithubRepository("greedy0110", "hello world")
        )
        assertThat(actual).isEqualTo(expected)
    }

}