package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.model.GithubDto
import camp.nextstep.edu.github.domain.model.Github
import com.google.common.truth.Truth.assertThat
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Test
import java.io.File

class MapperTest {

    @Test
    fun `GithubDto 객체를 Github 객체로 변경`() {
        // GIVEN
        val json = Json { ignoreUnknownKeys = true }
        val githubDto =
            json.decodeFromString<List<GithubDto>>(File("src/test/resources/repositories.json").readText())

        // WHEN
        val github = githubDto.first().mapper()

        // THEN
        assertThat(github).isInstanceOf(Github::class.java)
    }
}