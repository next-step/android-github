package camp.nextstep.edu.github.common.mappers

interface UiMapper<D, V> {

    fun mapToView(domain: D): V
}