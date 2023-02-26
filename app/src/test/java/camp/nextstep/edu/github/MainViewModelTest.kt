package camp.nextstep.edu.github

import com.google.common.truth.Truth
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import io.mockk.coEvery
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject


@HiltAndroidTest
class MainViewModelTest {
    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var githubRepository: GitHubRepository

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        hiltRule.inject()
        viewModel = MainViewModel(githubRepository)
    }

    @Test
    fun `깃허브 레포지토리 데이터 가져오기 테스트`() = runTest {
        // given
        val data = listOf(
            GitHubRepositoryInfo("First full name", "First description"),
            GitHubRepositoryInfo("Second full name", "Second description")
        )
        coEvery { githubRepository.getGitHubRepositoryInfo() } returns data

        // when
        val actual = githubRepository.getGitHubRepositoryInfo()

        // then
        Truth.assertThat(actual).isEqualTo(data)
    }


}