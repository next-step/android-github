package com.nextstep.edu.github.data.entity

import com.nextstep.edu.github.domain.dto.RepositoryItemDto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RepositoryItemTest {

    @Test
    fun `entity를 dto로 변환합니다`() {
        val (fullName, description) = "BeokBeok" to "github"
        val entity = RepositoryItem(
            fullName = fullName,
            description = description
        )
        val actual = entity.toDto()

        assertThat(actual)
            .isEqualTo(RepositoryItemDto(fullName = fullName, description = description))
    }
}
