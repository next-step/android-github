package camp.nextstep.edu.github

import camp.nextstep.edu.github.domain.model.GitHubRepo
import camp.nextstep.edu.github.domain.model.GitHubRepos
import camp.nextstep.edu.github.model.GitHubRepoViewData


fun GitHubRepos.toViewDataList() = repositories.map { it.toViewData() }
fun GitHubRepo.toViewData() = GitHubRepoViewData(id, "$fullName/Repository", description)
