package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepository
import camp.nextstep.edu.github.domain.Repo
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import java.io.File


class GithubRepositoryImplTest {
    private lateinit var server: MockWebServer
    private lateinit var repository: GithubRepository

    @BeforeEach
    fun setUp() {
        server = MockWebServer()
        repository = DataInjector.provideGithubRepository()
    }

    @Test
    fun `Github Repository 로드하여 첫번째 Repo 객체를 검증한다`() = runBlocking {
        val response = MockResponse()
            .setBody(File("src/test/resources/repositories.json").readText())
            .setResponseCode(200)

        server.enqueue(response)

        val expected = Repo(
            "mojombo/grit",
            "**Grit is no longer maintained. Check out libgit2/rugged.** Grit gives you object oriented read/write access to Git repositories via Ruby."
        )

        val actual = repository.getRepositories().firstOrNull()

        assertThat(actual).isEqualTo(expected)
    }
}