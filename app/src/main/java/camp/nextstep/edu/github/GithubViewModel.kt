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

    private val _errMessage = MutableLiveData<Event<String>>()
        val errMessage: LiveData<Event<String>>
            get() = _errMessage

    fun getRepositories() {
        getRepositoriesUseCase( {
            _githubData.value = it
        }, {
            _errMessage.value = Event(it.message.toString())
        })
    }

}