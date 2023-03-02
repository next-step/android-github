package camp.nextstep.edu.github

import com.google.common.truth.Truth
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import io.mockk.*
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import javax.inject.Inject


@HiltAndroidTest
@RunWith(RobolectricTestRunner::class)
@Config(application = HiltTestApplication::class)
class MainViewModelTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    private lateinit var viewModel: MainViewModel

    @set:Inject
    lateinit var repository: GitHubRepository

    @Before
    fun setUp() {
        hiltRule.inject()
        viewModel = MainViewModel(repository)
    }

    @Test
    fun `깃허브 레포지토리 데이터 가져오기 테스트`() = runTest {
        // when
        val actual = repository.getGitHubRepositoryInfo()

        viewModel.getGithubRepositoryInfo()
        val expected = viewModel.githubRepositoryInfo.getOrAwaitValue()

        Truth.assertThat(actual).isEqualTo(expected)
    }
}