package camp.nextstep.edu.github

import camp.nextstep.edu.github.domain.entity.GithubRepo
import camp.nextstep.edu.github.domain.exception.NotFoundUserException
import camp.nextstep.edu.github.domain.repository.GithubRepoRepository
import camp.nextstep.edu.github.utils.InstantTaskExecutorExtension
import camp.nextstep.edu.github.utils.MainCoroutineExtension
import camp.nextstep.edu.github.utils.ToastMessage
import camp.nextstep.edu.github.utils.takeValue
import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.extension.RegisterExtension

/**
 * Created By Malibin
 * on 9월 13, 2021
 */

@ExperimentalCoroutinesApi
internal class MainViewModelTest {

    companion object {
        @JvmField
        @RegisterExtension
        val instantTaskExecutorExtension = InstantTaskExecutorExtension()

        @JvmField
        @RegisterExtension
        val mainCoroutineExtension = MainCoroutineExtension()
    }

    private lateinit var mainViewModel: MainViewModel
    private lateinit var githubRepoRepository: GithubRepoRepository

    @BeforeEach
    fun setUp() {
        githubRepoRepository = mockk(relaxed = true)
        mainViewModel = MainViewModel(githubRepoRepository)
    }

    @Test
    fun `유저 이름에 해당하는 Github Repository 목록을 불러온다`() {
        // given
        val expectedGithubRepos = listOf(
            GithubRepo(
                id = 0,
                fullName = "fullName",
                description = "description",
            )
        )
        val githubReposResult = Result.success(expectedGithubRepos)
        coEvery { githubRepoRepository.getRepositoriesOf(any()) } returns githubReposResult

        // when
        mainViewModel.loadGithubRepos("malibinYun")

        // then
        val actualGithubRepos = mainViewModel.githubRepos.takeValue()
        assertAll(
            { Truth.assertThat(githubReposResult.isSuccess).isTrue() },
            { Truth.assertThat(actualGithubRepos).containsExactlyElementsIn(expectedGithubRepos) },
        )
    }

    @Test
    fun `없는 유저 이름으로 repo목록을 가져올 수 없고 토스트 메시지를 띄운다`() {
        // given
        val expectedException = NotFoundUserException()
        val githubReposResult = Result.failure<List<GithubRepo>>(expectedException)
        coEvery { githubRepoRepository.getRepositoriesOf("unknownUserName") } returns githubReposResult

        val expectedToastMessage = ToastMessage.StringValue("Cannot find github user")

        // when
        mainViewModel.loadGithubRepos("unknownUserName")

        // then
        val actualToastMessage = mainViewModel.toastMessage.takeValue()
        assertAll(
            { Truth.assertThat(githubReposResult.isFailure).isTrue() },
            { Truth.assertThat(actualToastMessage).isEqualTo(expectedToastMessage) },
        )
    }
}
