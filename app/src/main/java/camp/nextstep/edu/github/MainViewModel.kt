package camp.nextstep.edu.github

import androidx.lifecycle.ViewModel
import camp.nextstep.edu.github.domain.usecase.GetGithubStorageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getGithubStorageUseCase: GetGithubStorageUseCase
) : ViewModel() {
}