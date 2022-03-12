package camp.nextstep.edu.github

import androidx.lifecycle.ViewModel
import com.github.dodobest.domain.usecase.GetRepositoriesUseCase

class GithubViewModel(
    private val getRepositoriesUseCase: GetRepositoriesUseCase
) : ViewModel() {

}