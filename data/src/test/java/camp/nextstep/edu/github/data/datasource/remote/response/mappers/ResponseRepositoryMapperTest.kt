package camp.nextstep.edu.github.data.datasource.remote.response.mappers

import camp.nextstep.edu.github.data.datasource.remote.response.ResponseRepository
import camp.nextstep.edu.github.domain.model.Repository
import com.google.common.truth.Truth
import com.google.common.truth.Truth.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class ResponseRepositoryMapperTest {

    private lateinit var mapper: ResponseRepositoryMapper

    @BeforeEach
    internal fun setUp() {
        mapper = ResponseRepositoryMapper()
    }

    @Test
    internal fun `ResponseRepository 객체를 도메인 Repository 객체로 변환을 할 수 있어야 한다`() {
        // given
        val response = ResponseRepository("fullName", "descriptions")

        // when
        val actual = mapper.mapToDomain(response)

        // then
        val expected = Repository("fullName", "descriptions")
        assertThat(actual).isEqualTo(expected)
    }
}