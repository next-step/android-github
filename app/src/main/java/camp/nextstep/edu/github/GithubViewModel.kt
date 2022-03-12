package camp.nextstep.edu.github

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.dodobest.domain.GithubData
import com.github.dodobest.domain.usecase.GetRepositoriesUseCase

class GithubViewModel(
    private val getRepositoriesUseCase: GetRepositoriesUseCase
) : ViewModel() {
    private val _githubData = MutableLiveData<List<GithubData>>(emptyList())
        val githubData: LiveData<List<GithubData>>
            get() = _githubData

    private val _gitText = MutableLiveData<String>()
        val gitText: LiveData<String>
            get() = _gitText

    fun getRepositories() {
        _githubData.value = getRepositoriesUseCase()
        _gitText.value = _githubData.value.toString()
    }

}