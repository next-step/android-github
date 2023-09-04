package camp.nextstep.edu.github

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@ExperimentalCoroutinesApi
class GithubServiceTest {

	private lateinit var mockWebServer: MockWebServer
	private lateinit var githubService: GithubService

	@Before
	fun setUp() {
		mockWebServer = MockWebServer()
		githubService = Retrofit.Builder()
			.baseUrl(mockWebServer.url(""))
			.addConverterFactory(GsonConverterFactory.create())
			.build()
			.create(GithubService::class.java)
	}

	@Test
	fun `Github API 모든 레포지토리 가져오는 테스트`() = runBlocking {
		// given
		mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(RESPONSE_JSON))
		val expected = listOf(
			GithubRepoResponse(
				fullName = "octocat/Hello-World",
				description = "This is your first repository"
			),
			GithubRepoResponse(
				fullName = "mojombo/GitHub-Flavored-Markdown",
				description = "GitHub's flavor of Markdown."
			)
		)

		// when
		val actual = githubService.getRepositories()

		// then
		assertThat(actual).isEqualTo(expected)
	}

	companion object {
		private const val RESPONSE_JSON = """
			[
			  {
			    "id": 1,
			    "name": "octocat/Hello-World",
			    "full_name": "octocat/Hello-World",
			    "owner": {
			      "login": "octocat",
			      "id": 1,
			      "avatar_url": "https://avatars.githubusercontent.com/u/1?v=4",
			      "html_url": "https://github.com/octocat"
			    },
			    "description": "This is your first repository",
			    "html_url": "https://github.com/octocat/Hello-World",
			    "stargazers_count": 15000,
			    "forks_count": 2000,
			    "language": "Python"
			  },
			  {
			    "id": 2,
			    "name": "mojombo/GitHub-Flavored-Markdown",
			    "full_name": "mojombo/GitHub-Flavored-Markdown",
			    "owner": {
			      "login": "mojombo",
			      "id": 1,
			      "avatar_url": "https://avatars.githubusercontent.com/u/1?v=4",
			      "html_url": "https://github.com/mojombo"
			    },
			    "description": "GitHub's flavor of Markdown.",
			    "html_url": "https://github.com/mojombo/GitHub-Flavored-Markdown",
			    "stargazers_count": 8000,
			    "forks_count": 1300,
			    "language": "Ruby"
			  }
			]
		"""
	}
}