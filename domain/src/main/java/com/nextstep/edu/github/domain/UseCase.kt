package com.nextstep.edu.github.domain

interface UseCase<R> {

    suspend fun execute(): R
}
