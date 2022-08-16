package camp.nextstep.edu.github

import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import camp.nextstep.edu.github.domain.GithubRepository
import camp.nextstep.edu.github.extension.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain

import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class MainViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    lateinit var viewModel: MainViewModel
    lateinit var fakeRepository: GithubRepository

    @Before
    fun setUp() {
        fakeRepository = FakeGithubRepository()
        viewModel = MainViewModel(fakeRepository)
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @Test
    fun 저장소_데이터를_불러오는_메서드_호출_시_저장소를_불러올_수_있어야_한다() {
        //given
        val expected = FakeGithubRepository.fakeData

        //when
        viewModel.fetchGithubRepo()

        //then
        val actual = viewModel.gitRepo.getOrAwaitValue()
        assertThat(actual.list.first()).isEqualTo(expected)
    }
}