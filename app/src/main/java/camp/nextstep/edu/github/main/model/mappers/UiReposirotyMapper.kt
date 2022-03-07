package camp.nextstep.edu.github.main.model.mappers

import camp.nextstep.edu.github.common.mappers.UiMapper
import camp.nextstep.edu.github.domain.model.Repositories
import camp.nextstep.edu.github.domain.model.Repository
import camp.nextstep.edu.github.main.model.UiRepository

class UiRepositoryMapper : UiMapper<Repositories, List<UiRepository>> {

    override fun mapToView(domain: Repositories): List<UiRepository> = domain.getItems().map(::mapToUiRepository)

    private fun mapToUiRepository(item: Repository): UiRepository = UiRepository(item.fullName, item.descriptions)
}