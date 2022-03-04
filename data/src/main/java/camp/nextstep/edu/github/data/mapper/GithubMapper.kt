package camp.nextstep.edu.github.data.mapper

internal interface DataToDomainMapper<T> {
    fun mapper(): T
}

internal fun <T> List<DataToDomainMapper<T>>.mapping(): List<T> = map { it.mapper() }
