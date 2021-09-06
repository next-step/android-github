package camp.nextstep.edu.github

import camp.nextstep.edu.github.vo.RepositoryItemVo
import com.nextstep.edu.github.domain.RepositoriesFetchUseCase
import com.nextstep.edu.github.domain.dto.RepositoryItemDto
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(InstantExecutorExtension::class)
internal class MainViewModelTest {

    private val repositoriesFetchUseCase: RepositoriesFetchUseCase = mockk(relaxed = true)
    private lateinit var viewModel: MainViewModel

    @BeforeEach
    fun setup() {
        viewModel = MainViewModel(repositoriesFetchUseCase = repositoriesFetchUseCase)
    }

    @Test
    fun `깃헙 레파지토리 리스트를 불러옵니다`() = runBlocking {
        val mockResponse: List<RepositoryItemDto> = listOf(mockk(relaxed = true))
        coEvery {
            repositoriesFetchUseCase
                .execute()
                .getOrNull()
        } returns mockResponse

        viewModel.fetchRepositories()

        assertEquals(viewModel.repositories.value, mockResponse.map(RepositoryItemVo::fromDto))
    }
}
