package camp.nextstep.edu.github

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import camp.nextstep.edu.github.ui.GithubViewModel
import com.google.common.truth.Truth
import com.nextstep.edu.domain.model.Repository
import com.nextstep.edu.domain.repository.RemoteRepository
import com.nextstep.edu.domain.usecase.GetRepositoryUseCase
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@OptIn(ExperimentalCoroutinesApi::class)
@HiltAndroidTest
@RunWith(RobolectricTestRunner::class)
@Config(application = HiltTestApplication::class)
class GithubViewModelTest {

    @get:Rule
    var hiltrule = HiltAndroidRule(this)

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var getRepositoryUseCase: GetRepositoryUseCase
    private lateinit var viewModel: GithubViewModel
    private val testDispatcher = StandardTestDispatcher()
    private val testScope = TestScope(testDispatcher)

    @Before
    fun setup() {
        val remoteRepository: RemoteRepository = mockk()
        getRepositoryUseCase = GetRepositoryUseCase(remoteRepository)
        viewModel = GithubViewModel(getRepositoryUseCase = getRepositoryUseCase)
    }

    @Test
    fun `getRepositoryUseCase의 결과인 리스트의 첫번째 fullName은 Hwang-Gyuil이다`() = testScope.runTest {
        // given : getRepositoryUseCase()의 결과 설정
        coEvery {
            getRepositoryUseCase()
        } returns Result.success(listOf(Repository(id = 0, fullName = "Hwang-Gyuil", description = "hi")))

        // when : getRepositoryUseCase() 메서드 실행
        viewModel.getRepositories()

        // then : 첫번째 인덱스의 fullName은 Hwang-Gyuil이다.
        val actual = viewModel.repositories.getOrAwaitValue(0)[0].fullName
        Truth.assertThat(actual).isEqualTo("Hwang-Gyuil")
    }

    @Test
    fun `getRepositoryUseCase호출 실패시 errorEvent를 호출한다`() = testScope.runTest {
        // given : getRepositoryUseCase()의 결과 설정
        coEvery {
            getRepositoryUseCase()
        } returns Result.failure(Throwable(message = "500 Internal Server Error"))

        // when : getRepositoryUseCase() 메서드 실행
        viewModel.getRepositories()

        // then : 첫번째 인덱스의 fullName은 Hwang-Gyuil이다.
        val actual = viewModel.errorEvent.getOrAwaitValue(0)
        Truth.assertThat(actual).isEqualTo(actual)
    }
}
