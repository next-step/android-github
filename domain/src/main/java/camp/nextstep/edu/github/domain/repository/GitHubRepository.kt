package camp.nextstep.edu.github.domain.repository

import camp.nextstep.edu.github.domain.model.GitHub

interface GitHubRepository {

    suspend fun fetch(): List<GitHub>
}
