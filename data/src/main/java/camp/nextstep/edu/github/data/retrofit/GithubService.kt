/**
 * @author Daewon on 31,August,2023
 *
 */

package camp.nextstep.edu.github.data.retrofit

import camp.nextstep.edu.github.data.response.GithubRepositoryResponse
import retrofit2.http.GET


internal interface GithubService {
    @GET("repositories")
    suspend fun getRepositories(): List<GithubRepositoryResponse>
}
