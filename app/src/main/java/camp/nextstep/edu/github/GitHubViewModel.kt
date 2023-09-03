package camp.nextstep.edu.github

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.github_domain.GitHubRepository
import kotlinx.coroutines.launch

class GitHubViewModel(private val gitHubRepository: GitHubRepository) : ViewModel() {

    fun insertGitHubRepository() {
        gitHubRepository.insertGitHubRepository()
    }
}
