package camp.nextstep.edu.github

internal class GitHubRepositoryImpl(
    private val retrofitService: RetrofitService
) : GitHubRepository {
    override fun getGitHubInfo(): List<GitHubInfoModel> {
        return retrofitService.getGitHubRepository().execute().body()?.map { it.fromGitHubInfoModel() }
            ?: throw IllegalArgumentException()
    }
}