package camp.nextstep.edu.github

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.dodobest.domain.GithubData
import com.github.dodobest.domain.RESPONSE_STATE
import com.github.dodobest.domain.usecase.GetRepositoriesUseCase

class GithubViewModel(
    private val getRepositoriesUseCase: GetRepositoriesUseCase
) : ViewModel() {
    private val _githubData = MutableLiveData<List<GithubData>>(emptyList())
        val githubData: LiveData<List<GithubData>>
            get() = _githubData

    fun getRepositories() {
        getRepositoriesUseCase {
                responseState: RESPONSE_STATE, dataBody: List<GithubData> -> _githubData.value = dataBody
        }
    }

}