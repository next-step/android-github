package camp.nextstep.edu.github

interface GitHubRepository {
    fun getGitHubInfo() : List<GitHubInfoModel>
}