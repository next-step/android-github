package camp.nextstep.edu.github.data.remote

import camp.nextstep.edu.github.data.dto.GitHubDto
import javax.inject.Inject

internal class GitHubDataSource @Inject constructor(
    private val gitHubService: GitHubService
) {
    suspend fun fetch(): List<GitHubDto> = gitHubService
        .fetch()
}
