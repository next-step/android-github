package camp.nextstep.edu.github

import camp.nextstep.edu.github.domain.model.GitHubRepo
import camp.nextstep.edu.github.domain.model.GitHubRepos


fun GitHubRepos.toViewDataList() = repositories.map { it.toViewData() }
fun GitHubRepo.toViewData() = GitHubRepoViewData(id, "$fullName/Repository", description)
