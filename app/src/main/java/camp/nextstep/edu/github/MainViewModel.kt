package camp.nextstep.edu.github

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.GetGithubListUseCase
import camp.nextstep.edu.github.domain.Github
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * 클래스에 대한 간단한 설명이나 참고 url을 남겨주세요.
 * Created by jeongjinhong on 2022. 08. 05..
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val getGithubListUseCase: GetGithubListUseCase
) : ViewModel() {

    private var _githubs: MutableLiveData<List<Github>> =
        MutableLiveData(listOf())
    val githubs: LiveData<List<Github>>
        get() = _githubs

    fun loadGithub() {
        viewModelScope.launch {
            _githubs.value = getGithubListUseCase.execute()
        }
    }
}