package camp.nextstep.edu.github.domain

interface GitRepository {

    suspend fun getRepository(): Result<List<GitResponseData>>

}