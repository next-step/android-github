package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GitRepoRepository
import retrofit2.create
import retrofit2.http.GET
import camp.nextstep.edu.github.domain.GitRepo as DomainGitRepo

internal class GithubService(
    private val service: GithubRetrofitService = RetrofitProvider.get().create()
) : GitRepoRepository {

    suspend fun getRepositories(): List<GitRepo> {
        return service.getRepositories()
    }

    override suspend fun getGitRepos(): List<DomainGitRepo> {
        return getRepositories().map { with(it) { DomainGitRepo(fullName, description) } }
    }
}

internal interface GithubRetrofitService {
    @GET("/repositories")
    suspend fun getRepositories(): List<GitRepo>
}

object Injector {
    fun getGitRepoRepository(): GitRepoRepository {
        return GithubService()
    }
}