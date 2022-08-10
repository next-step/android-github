package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.VO

interface Mapper<T: DTO, V: VO> {
    fun toVO(entity: T): V

    fun toDTO(vo: V): T
}