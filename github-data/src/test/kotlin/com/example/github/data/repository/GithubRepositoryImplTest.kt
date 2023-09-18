package com.example.github.data.repository

import com.example.github.GitHubApi
import com.example.github.data.repository.local.FakeLocalGithubDataSourceImpl
import com.example.github.data.repository.remote.RemoteGithubDataSourceImpl
import com.example.github.data.repository.remote.data.Owner
import com.example.github.data.repository.remote.data.RemoteGithubData
import com.example.githubdomain.GithubRepoData
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.io.File

@OptIn(ExperimentalCoroutinesApi::class)
class GithubRepositoryImplTest {
    private val server = MockWebServer()

    private lateinit var service: GitHubApi
    private lateinit var githubRepositoryImpl: GithubRepositoryImpl

    @Before
    fun init() {
        val baseUrl = server.url("")

        service = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
            .create()

        githubRepositoryImpl = GithubRepositoryImpl(
            localGithubDataSource = FakeLocalGithubDataSourceImpl(),
            remoteGithubDataSource = RemoteGithubDataSourceImpl(service)
        )
    }

    @Test
    fun `githubRepoSingle_json(remoteData)을 내려줄 때, GitHubInfo를 받아오면 올바른 결과값을 반환해야한다`() =
        runTest(UnconfinedTestDispatcher()) {
            // given : MockResponse을 활용해 서버 응답을 세팅해둔다.
            val response = MockResponse()
                .setBody(File("src/test/resources/githubRepoSingle.json").readText())
                .setResponseCode(200)

            server.enqueue(response)

            // when :mock서버에 HTTP통신 요청을 한다.
            val actual = service.getGitHubRepo().body()

            // then : 응답 받은 값과 비교한다.
            val expected = listOf(
                RemoteGithubData(
                    id = 1,
                    nodeId = "MDEwOlJlcG9zaXRvcnkx",
                    name = "grit",
                    fullName = "mojombo/grit",
                    private = false,
                    owner = Owner(
                        login = "mojombo",
                        id = 1,
                        nodeId = "MDQ6VXNlcjE=",
                        avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4",
                        gravatarId = "",
                        url = "https://api.github.com/users/mojombo",
                        htmlUrl = "https://github.com/mojombo",
                        followersUrl = "https://api.github.com/users/mojombo/followers",
                        followingUrl = "https://api.github.com/users/mojombo/following{/other_user}",
                        gistsUrl = "https://api.github.com/users/mojombo/gists{/gist_id}",
                        starredUrl = "https://api.github.com/users/mojombo/starred{/owner}{/repo}",
                        subscriptionsUrl = "https://api.github.com/users/mojombo/subscriptions",
                        organizationsUrl = "https://api.github.com/users/mojombo/orgs",
                        reposUrl = "https://api.github.com/users/mojombo/repos",
                        eventsUrl = "https://api.github.com/users/mojombo/events{/privacy}",
                        receivedEventsUrl = "https://api.github.com/users/mojombo/received_events",
                        type = "User",
                        siteAdmin = false
                    ),
                    htmlUrl = "https://github.com/mojombo/grit",
                    description = "**Grit is no longer maintained. Check out libgit2/rugged.** Grit gives you object oriented read/write access to Git repositories via Ruby.",
                    fork = false,
                    url = "https://api.github.com/repos/mojombo/grit",
                    forksUrl = "https://api.github.com/repos/mojombo/grit/forks",
                    keysUrl = "https://api.github.com/repos/mojombo/grit/keys{/key_id}",
                    collaboratorsUrl = "https://api.github.com/repos/mojombo/grit/collaborators{/collaborator}",
                    teamsUrl = "https://api.github.com/repos/mojombo/grit/teams",
                    hooksUrl = "https://api.github.com/repos/mojombo/grit/hooks",
                    issueEventsUrl = "https://api.github.com/repos/mojombo/grit/issues/events{/number}",
                    eventsUrl = "https://api.github.com/repos/mojombo/grit/events",
                    assigneesUrl = "https://api.github.com/repos/mojombo/grit/assignees{/user}",
                    branchesUrl = "https://api.github.com/repos/mojombo/grit/branches{/branch}",
                    tagsUrl = "https://api.github.com/repos/mojombo/grit/tags",
                    blobsUrl = "https://api.github.com/repos/mojombo/grit/git/blobs{/sha}",
                    gitTagsUrl = "https://api.github.com/repos/mojombo/grit/git/tags{/sha}",
                    gitRefsUrl = "https://api.github.com/repos/mojombo/grit/git/refs{/sha}",
                    treesUrl = "https://api.github.com/repos/mojombo/grit/git/trees{/sha}",
                    statusesUrl = "https://api.github.com/repos/mojombo/grit/statuses/{sha}",
                    languagesUrl = "https://api.github.com/repos/mojombo/grit/languages",
                    stargazersUrl = "https://api.github.com/repos/mojombo/grit/stargazers",
                    contributorsUrl = "https://api.github.com/repos/mojombo/grit/contributors",
                    subscribersUrl = "https://api.github.com/repos/mojombo/grit/subscribers",
                    subscriptionUrl = "https://api.github.com/repos/mojombo/grit/subscription",
                    commitsUrl = "https://api.github.com/repos/mojombo/grit/commits{/sha}",
                    gitCommitsUrl = "https://api.github.com/repos/mojombo/grit/git/commits{/sha}",
                    commentsUrl = "https://api.github.com/repos/mojombo/grit/comments{/number}",
                    issueCommentUrl = "https://api.github.com/repos/mojombo/grit/issues/comments{/number}",
                    contentsUrl = "https://api.github.com/repos/mojombo/grit/contents/{+path}",
                    compareUrl = "https://api.github.com/repos/mojombo/grit/compare/{base}...{head}",
                    mergesUrl = "https://api.github.com/repos/mojombo/grit/merges",
                    archiveUrl = "https://api.github.com/repos/mojombo/grit/{archive_format}{/ref}",
                    downloadsUrl = "https://api.github.com/repos/mojombo/grit/downloads",
                    issuesUrl = "https://api.github.com/repos/mojombo/grit/issues{/number}",
                    pullsUrl = "https://api.github.com/repos/mojombo/grit/pulls{/number}",
                    milestonesUrl = "https://api.github.com/repos/mojombo/grit/milestones{/number}",
                    notificationsUrl = "https://api.github.com/repos/mojombo/grit/notifications{?since,all,participating}",
                    labelsUrl = "https://api.github.com/repos/mojombo/grit/labels{/name}",
                    releasesUrl = "https://api.github.com/repos/mojombo/grit/releases{/id}",
                    deploymentsUrl = "https://api.github.com/repos/mojombo/grit/deployments"
                )
            )
            assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `githubRepo_json을 내려줄 때 처음으로 GitHubInfo를 받아오면 localRepository에 저장된다`() = runTest(UnconfinedTestDispatcher()) {
        // given : 응답값으로 githubRepo_json을 설정해준다.
        //         초기 로컬 레파지토리는 비어있다.
        val response = MockResponse()
            .setBody(File("src/test/resources/githubRepo.json").readText())
            .setResponseCode(200)

        server.enqueue(response)

        assertThat(githubRepositoryImpl.isEmptyLocalData()).isEqualTo(true)

        // when : GitHubRepoData를 받아온다
        githubRepositoryImpl.getGitHubRepoData()

        // then :
        assertThat(githubRepositoryImpl.isEmptyLocalData()).isEqualTo(false)
    }

    @Test
    fun `githubRepo_json을 내려줄 때, GitHubRepoData를 받아오면 올바른 결과값을 반환해야한다`() =
        runTest(UnconfinedTestDispatcher()) {
            // given : MockResponse을 활용해 서버 응답을 세팅해둔다.
            val response = MockResponse()
                .setBody(File("src/test/resources/githubRepo.json").readText())
                .setResponseCode(200)

            server.enqueue(response)

            // when : MockWebServer에 HTTP통신 요청을 한다.
            val actual = githubRepositoryImpl.getGitHubRepoData()

            // then : 응답 받은 값과 비교한다.
            val expected = listOf(
                GithubRepoData(
                    1,
                    "mojombo/grit",
                    "**Grit is no longer maintained. Check out libgit2/rugged.** Grit gives you object oriented read/write access to Git repositories via Ruby."
                ),
                GithubRepoData(26, "wycats/merb-core", "Merb Core: All you need. None you don't."),
                GithubRepoData(27, "rubinius/rubinius", "The Rubinius Language Platform"),
                GithubRepoData(28, "mojombo/god", "Ruby process monitor"),
            )

            assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `githubRepo_json을 내려줄 때, 정상 응답이 아니라면 공백 리스트 값을 반환해야한다`() =
        runTest(UnconfinedTestDispatcher()) {
            // given : MockResponse을 활용해 서버 응답을 세팅해둔다.
            val response = MockResponse()
                .setBody(File("src/test/resources/githubRepo.json").readText())
                .setResponseCode(500)

            server.enqueue(response)

            // when : MockWebServer에 HTTP통신 요청을 한다.
            val actual = githubRepositoryImpl.getGitHubRepoData()

            // then : 응답 받은 값과 비교한다.
            assertThat(actual).isEmpty()
        }

    @Test
    fun `Json 파싱이 잘못 됐을 때, 공백 리스트 값을 반환해야한다`() =
        runTest(UnconfinedTestDispatcher()) {
            // given : 네트워크 연결 끊김
            val response = MockResponse()
                .setBody("Invalid JSON")

            server.enqueue(response)

            // when : MockWebServer에 HTTP통신 요청을 한다.
            val actual = githubRepositoryImpl.getGitHubRepoData()

            // then : 응답 받은 값과 비교한다.
            assertThat(actual).isEmpty()
        }

    @Test
    fun `네트워크 연결이 끊겨있으면, 정상 응답이 아니라면 공백 리스트 값을 반환해야한다`() =
        runTest(UnconfinedTestDispatcher()) {
            // given : 네트워크 연결 끊김

            // when : MockWebServer에 HTTP통신 요청을 한다.
            val actual = githubRepositoryImpl.getGitHubRepoData()

            // then : 응답 받은 값과 비교한다.
            assertThat(actual).isEmpty()
        }

    @Test
    fun `emptyGithubRepo_Json을 내려줄 때, GitHubRepoData를 받아오면 올바른 결과값을 반환해야한다`() =
        runTest(UnconfinedTestDispatcher()) {
            // given : MockResponse을 활용해 서버 응답을 세팅해둔다.
            val response = MockResponse()
                .setBody(File("src/test/resources/emptyGithubRepo.json").readText())
                .setResponseCode(200)

            server.enqueue(response)

            // when : MockWebServer에 HTTP통신 요청을 한다.
            val actual = githubRepositoryImpl.getGitHubRepoData()

            // then : 응답 받은 값과 비교한다.
            val expected = listOf<GithubRepoData>()
            assertThat(actual).isEqualTo(expected)
        }
}
