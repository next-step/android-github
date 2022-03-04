package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.model.GithubResponse
import camp.nextstep.edu.github.domain.model.Github
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class MapperTest {

    @Test
    fun `GithubDto 객체를 Github 객체로 변경`() {
        // GIVEN
        val githubResponse = listOf(
            GithubResponse(
                fullName = "ganghee",
                description = "MyRepository"
            )
        )
        val expected = Github(
            fullName = "ganghee",
            description = "MyRepository"
        )

        // WHEN
        val actual = githubResponse.first().mapper()

        // THEN
        assertThat(actual).isEqualTo(expected)
    }
}
