package camp.nextstep.edu.github.vo

import com.nextstep.edu.github.domain.dto.RepositoryItemDto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RepositoryItemVoTest {

    @Test
    fun `dto를 vo로 변환합니다`() {
        val (fullName, description) = "BeokBeok" to "github"
        val dto = RepositoryItemDto(fullName = fullName, description = description)

        val actual = RepositoryItemVo.fromDto(dto)

        assertThat(actual)
            .isEqualTo(RepositoryItemVo(fullName = fullName, description = description))
    }
}
