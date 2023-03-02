package camp.nextstep.edu.github

import com.google.common.truth.Truth
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
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

//    @get:Rule
//    val mainDispatcherRule = MainDispatcherRule()

    @set:Inject
    lateinit var githubRepository: GitHubRepository

    @Test
    fun `Repository 주입 테스트`() {
        Truth.assertThat(::githubRepository.isInitialized).isEqualTo(false)
        hiltRule.inject()
        Truth.assertThat(::githubRepository.isInitialized).isEqualTo(true)
    }

//    private lateinit var viewModel: MainViewModel
//
//    @Before
//    fun setUp() {
//        hiltRule.inject()
//        viewModel = MainViewModel(githubRepository)
//    }
//
//    @Test
//    fun `깃허브 레포지토리 데이터 가져오기 테스트`() = runBlocking {
//        // given
//        val data = listOf(
//            GitHubRepositoryInfo("First full name", "First description"),
//            GitHubRepositoryInfo("Second full name", "Second description")
//        )
//
//        coEvery { githubRepository.getGitHubRepositoryInfo() } returns data
//
//        // when
//        val actual = githubRepository.getGitHubRepositoryInfo()
//
//        // then
//        Truth.assertThat(actual).isEqualTo(data)
//    }
}