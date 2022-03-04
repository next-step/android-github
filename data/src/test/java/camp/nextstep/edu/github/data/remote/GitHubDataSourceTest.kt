package camp.nextstep.edu.github.data.remote

import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class GitHubDataSourceTest {

    private lateinit var gitHubDataSource: GitHubDataSource

    @BeforeEach
    fun setup() {
        gitHubDataSource = GitHubDataSource(Fixture.mockGitHubService())
    }

    @DisplayName("GitHub Repositories HTTP 결과를 불러와야 합니다.")
    @Test
    fun fetch(): Unit = runBlocking {
        val actual = gitHubDataSource.fetch()
        assertThat(actual.size).isEqualTo(2)
    }
}
