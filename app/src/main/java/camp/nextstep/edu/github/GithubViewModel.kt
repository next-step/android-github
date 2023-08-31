package camp.nextstep.edu.github

import androidx.lifecycle.ViewModel
import com.nextstep.edu.domain.usecase.GetRepositoryUseCase

class GithubViewModel(
    private val getRepositoryUseCase: GetRepositoryUseCase
): ViewModel() {

}
