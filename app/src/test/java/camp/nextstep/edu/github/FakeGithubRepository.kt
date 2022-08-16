package camp.nextstep.edu.github

import camp.nextstep.edu.github.domain.GithubRepo
import camp.nextstep.edu.github.domain.GithubRepositories
import camp.nextstep.edu.github.domain.GithubRepository

class FakeGithubRepository: GithubRepository {
    override suspend fun getRepo(): GithubRepositories =
        GithubRepositories(
            listOf(fakeData)
        )

    companion object {
        val fakeData = GithubRepo(1, "test name", "test description")
    }
}