package camp.nextstep.edu.github

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.GetRepositoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getRepositoryUseCase: GetRepositoriesUseCase
) : ViewModel() {

    fun printRepositories() {
        viewModelScope.launch { getRepositoryUseCase().run { Log.e("MIN", "test => $this") } }
    }
}