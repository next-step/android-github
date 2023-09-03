package camp.nextstep.edu.github

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.github_data.room.GithubRepoDao
import com.example.github_data.room.Injector

class GithubViewModelFactory(private val githubRepoDao: GithubRepoDao) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GitHubViewModel::class.java)) {
            return GitHubViewModel(Injector.providesGithubRepoRepository(githubRepoDao)) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
