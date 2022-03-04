package camp.nextstep.edu.github.data.remote

import camp.nextstep.edu.github.domain.model.GitHub
import camp.nextstep.edu.github.domain.repository.GitHubRepository
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class GitHubRepositoryImplTest {

    private lateinit var gitHubRepository: GitHubRepository

    @BeforeEach
    fun setup() {
        gitHubRepository = GitHubRepositoryImpl(Fixture.mockGitHubDataSource())
    }

    @DisplayName("GitHub Repositories HTTP 결과를 불러와야 합니다.")
    @Test
    fun fetch(): Unit = runBlocking {
        val actual = gitHubRepository.fetch()
        val expected = listOf(
            GitHub(
                fullName = "mojombo/grit",
                description = "**Grit is no longer maintained. Check out libgit2/rugged.** Grit gives you object oriented read/write access to Git repositories via Ruby."
            ),
            GitHub(
                fullName = "wycats/merb-core",
                description = "Merb Core: All you need. None you don't."
            )
        )
        Assertions.assertThat(actual).isEqualTo(expected)
    }
}
