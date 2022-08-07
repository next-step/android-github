package camp.nextstep.edu.github

import camp.nextstep.edu.github.domain.GithubRepository
import kotlinx.coroutines.runBlocking
import okhttp3.HttpUrl
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Test

import org.junit.Assert.*
import org.junit.jupiter.api.BeforeEach
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

internal class GithubServiceTest {

    private lateinit var server: MockWebServer
    private lateinit var service: GithubRepository

    @BeforeEach
    fun setup() {
        server = MockWebServer()
        server.start()
        val retrofit = createRetrofit(server.url("/"))
        service = createGitRepoRepository(retrofit)
    }

    @Test
    fun `Repository를 받아온다`() = runBlocking {
        // given
        val mockJsonString = getMockGetRepoJsonString()
        server.enqueue(MockResponse().setBody(mockJsonString))

        // when
        val actual = service.getGithubService().listRepos()

        // then
        assertNotNull(actual.size)
    }


//    private fun getMockFile(): File {
//        return File(javaClass.getResource("/repos.json").toURI())
//    }

    private fun getMockGetRepoJsonString(): String {
        return "{\n" +
                "    \"id\": 1,\n" +
                "    \"node_id\": \"MDEwOlJlcG9zaXRvcnkx\",\n" +
                "    \"name\": \"grit\",\n" +
                "    \"full_name\": \"mojombo/grit\",\n" +
                "    \"private\": false,\n" +
                "    \"owner\": {\n" +
                "      \"login\": \"mojombo\",\n" +
                "      \"id\": 1,\n" +
                "      \"node_id\": \"MDQ6VXNlcjE=\",\n" +
                "      \"avatar_url\": \"https://avatars.githubusercontent.com/u/1?v=4\",\n" +
                "      \"gravatar_id\": \"\",\n" +
                "      \"url\": \"https://api.github.com/users/mojombo\",\n" +
                "      \"html_url\": \"https://github.com/mojombo\",\n" +
                "      \"followers_url\": \"https://api.github.com/users/mojombo/followers\",\n" +
                "      \"following_url\": \"https://api.github.com/users/mojombo/following{/other_user}\",\n" +
                "      \"gists_url\": \"https://api.github.com/users/mojombo/gists{/gist_id}\",\n" +
                "      \"starred_url\": \"https://api.github.com/users/mojombo/starred{/owner}{/repo}\",\n" +
                "      \"subscriptions_url\": \"https://api.github.com/users/mojombo/subscriptions\",\n" +
                "      \"organizations_url\": \"https://api.github.com/users/mojombo/orgs\",\n" +
                "      \"repos_url\": \"https://api.github.com/users/mojombo/repos\",\n" +
                "      \"events_url\": \"https://api.github.com/users/mojombo/events{/privacy}\",\n" +
                "      \"received_events_url\": \"https://api.github.com/users/mojombo/received_events\",\n" +
                "      \"type\": \"User\",\n" +
                "      \"site_admin\": false\n" +
                "    },\n" +
                "    \"html_url\": \"https://github.com/mojombo/grit\",\n" +
                "    \"description\": \"**Grit is no longer maintained. Check out libgit2/rugged.** Grit gives you object oriented read/write access to Git repositories via Ruby.\",\n" +
                "    \"fork\": false,\n" +
                "    \"url\": \"https://api.github.com/repos/mojombo/grit\",\n" +
                "    \"forks_url\": \"https://api.github.com/repos/mojombo/grit/forks\",\n" +
                "    \"keys_url\": \"https://api.github.com/repos/mojombo/grit/keys{/key_id}\",\n" +
                "    \"collaborators_url\": \"https://api.github.com/repos/mojombo/grit/collaborators{/collaborator}\",\n" +
                "    \"teams_url\": \"https://api.github.com/repos/mojombo/grit/teams\",\n" +
                "    \"hooks_url\": \"https://api.github.com/repos/mojombo/grit/hooks\",\n" +
                "    \"issue_events_url\": \"https://api.github.com/repos/mojombo/grit/issues/events{/number}\",\n" +
                "    \"events_url\": \"https://api.github.com/repos/mojombo/grit/events\",\n" +
                "    \"assignees_url\": \"https://api.github.com/repos/mojombo/grit/assignees{/user}\",\n" +
                "    \"branches_url\": \"https://api.github.com/repos/mojombo/grit/branches{/branch}\",\n" +
                "    \"tags_url\": \"https://api.github.com/repos/mojombo/grit/tags\",\n" +
                "    \"blobs_url\": \"https://api.github.com/repos/mojombo/grit/git/blobs{/sha}\",\n" +
                "    \"git_tags_url\": \"https://api.github.com/repos/mojombo/grit/git/tags{/sha}\",\n" +
                "    \"git_refs_url\": \"https://api.github.com/repos/mojombo/grit/git/refs{/sha}\",\n" +
                "    \"trees_url\": \"https://api.github.com/repos/mojombo/grit/git/trees{/sha}\",\n" +
                "    \"statuses_url\": \"https://api.github.com/repos/mojombo/grit/statuses/{sha}\",\n" +
                "    \"languages_url\": \"https://api.github.com/repos/mojombo/grit/languages\",\n" +
                "    \"stargazers_url\": \"https://api.github.com/repos/mojombo/grit/stargazers\",\n" +
                "    \"contributors_url\": \"https://api.github.com/repos/mojombo/grit/contributors\",\n" +
                "    \"subscribers_url\": \"https://api.github.com/repos/mojombo/grit/subscribers\",\n" +
                "    \"subscription_url\": \"https://api.github.com/repos/mojombo/grit/subscription\",\n" +
                "    \"commits_url\": \"https://api.github.com/repos/mojombo/grit/commits{/sha}\",\n" +
                "    \"git_commits_url\": \"https://api.github.com/repos/mojombo/grit/git/commits{/sha}\",\n" +
                "    \"comments_url\": \"https://api.github.com/repos/mojombo/grit/comments{/number}\",\n" +
                "    \"issue_comment_url\": \"https://api.github.com/repos/mojombo/grit/issues/comments{/number}\",\n" +
                "    \"contents_url\": \"https://api.github.com/repos/mojombo/grit/contents/{+path}\",\n" +
                "    \"compare_url\": \"https://api.github.com/repos/mojombo/grit/compare/{base}...{head}\",\n" +
                "    \"merges_url\": \"https://api.github.com/repos/mojombo/grit/merges\",\n" +
                "    \"archive_url\": \"https://api.github.com/repos/mojombo/grit/{archive_format}{/ref}\",\n" +
                "    \"downloads_url\": \"https://api.github.com/repos/mojombo/grit/downloads\",\n" +
                "    \"issues_url\": \"https://api.github.com/repos/mojombo/grit/issues{/number}\",\n" +
                "    \"pulls_url\": \"https://api.github.com/repos/mojombo/grit/pulls{/number}\",\n" +
                "    \"milestones_url\": \"https://api.github.com/repos/mojombo/grit/milestones{/number}\",\n" +
                "    \"notifications_url\": \"https://api.github.com/repos/mojombo/grit/notifications{?since,all,participating}\",\n" +
                "    \"labels_url\": \"https://api.github.com/repos/mojombo/grit/labels{/name}\",\n" +
                "    \"releases_url\": \"https://api.github.com/repos/mojombo/grit/releases{/id}\",\n" +
                "    \"deployments_url\": \"https://api.github.com/repos/mojombo/grit/deployments\"\n" +
                "  }"
    }

    private fun createRetrofit(baseUrl: HttpUrl): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun createGitRepoRepository(retrofit: Retrofit): GithubRepository {
        return retrofit.create()
    }
}
