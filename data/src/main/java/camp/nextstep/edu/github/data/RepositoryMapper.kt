package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.Repository

/**
 * Created by link.js on 2022. 08. 05..
 */

internal fun RepositoryDto.toDomain() = Repository(fullName, description)