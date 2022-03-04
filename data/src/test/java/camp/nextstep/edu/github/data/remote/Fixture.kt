package camp.nextstep.edu.github.data.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File

internal class Fixture {
    private val mockServer = MockWebServer()

    init {
        mockServer.enqueue(
            MockResponse()
                .setBody(File("src/test/resources/github.json").readText())
        )
    }

    private val gitHubService = Retrofit
        .Builder()
        .baseUrl(mockServer.url(""))
        .addConverterFactory(
            MoshiConverterFactory.create(
                Moshi
                    .Builder()
                    .add(KotlinJsonAdapterFactory())
                    .build()
            )
        )
        .build()
        .create(GitHubService::class.java)

    companion object {
        fun mockGitHubService(): GitHubService = Fixture().gitHubService
        fun mockGitHubDataSource(): GitHubDataSource = GitHubDataSource(mockGitHubService())
    }
}
