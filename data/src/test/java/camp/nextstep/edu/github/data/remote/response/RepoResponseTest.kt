package camp.nextstep.edu.github.data.remote.response

import com.google.common.truth.Expect
import org.junit.Rule
import org.junit.Test

class RepoResponseTest {

    @get:Rule
    val expect: Expect = Expect.create()

    @Test
    fun `Response는 Entity로 정상적으로 변환해야한다`() {
        // given
        val testId = 1L
        val testName = "Name for Test"
        val testDescription = "Description for Test"
        val response = RepoResponse(id = testId, fullName = testName, description = testDescription)

        // when
        val entity = response.toEntity()

        // then
        expect.that(entity.id).isEqualTo(testId)
        expect.that(entity.fullName).isEqualTo(testName)
        expect.that(entity.description).isEqualTo(testDescription)
    }
}