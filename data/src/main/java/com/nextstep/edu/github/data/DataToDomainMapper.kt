package com.nextstep.edu.github.data

interface DataToDomainMapper<T> {

    fun toDto(): T
}

fun <T> List<DataToDomainMapper<T>>.toDto(): List<T> = map { it.toDto() }
