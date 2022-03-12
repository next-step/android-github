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

    private val _gitText = MutableLiveData<String>()
        val gitText: LiveData<String>
            get() = _gitText

    fun getRepositories() {
//        _githubData.value = getRepositoriesUseCase()
        var responseText = ""
        getRepositoriesUseCase {
            responseState: RESPONSE_STATE, responseBody: List<GithubData> ->

            when(responseState) {
                RESPONSE_STATE.OK -> {
                    for (gitData: GithubData in responseBody) {
                        responseText += "${gitData.full_name} : ${gitData.description}\n"
                    }
                }
                RESPONSE_STATE.FAIL -> {
                    responseText = "${responseBody[0].full_name} : ${responseBody[0].description}\n"
                }
            }
            _gitText.value = responseText
        }
    }

}