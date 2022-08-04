package camp.nextstep.edu.github.data

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

internal class GithubServiceTest {

    private val service = GithubService()

    @Test
    fun `full_name, descroption을 받아온다`() {
        // when
        val actual = service.getRepositories()
        
        // then
        val expected = listOf(
            GithubRepository("greedy0110", "hello world")
        )
        assertThat(actual).isEqualTo(expected)
    }

}