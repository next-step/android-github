package camp.nextstep.edu.github.ui.main

import camp.nextstep.edu.github.domain.GithubRepository
import camp.nextstep.edu.github.ui.UiStatus

data class GithubMainState(
    val status: UiStatus? = null,
    val repositories: List<GithubRepository> = emptyList()
)
