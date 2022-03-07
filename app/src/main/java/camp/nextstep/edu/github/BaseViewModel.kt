package camp.nextstep.edu.github

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.Resource
import camp.nextstep.edu.github.domain.model.base.BaseEntity
import kotlinx.coroutines.flow.*

abstract class BaseViewModel : ViewModel() {

    val isShowProgress = MutableStateFlow(false)

    val eventShowErrorSnackBar = MutableSharedFlow<Unit>()

    protected suspend fun showProgressDialog() {
        isShowProgress.emit(true)
    }

    protected suspend fun hideProgressDialog() {
        isShowProgress.emit(false)
    }

    protected suspend fun showErrorSnackBar() {
        eventShowErrorSnackBar.emit(Unit)
    }

    fun <T : BaseEntity> Flow<Resource<T>>.handleResultWithState(onSuccess: (T) -> Unit) {
        onEach { result ->
            when (result) {
                is Resource.Loading -> showProgressDialog()
                is Resource.Success -> {
                    hideProgressDialog()
                    onSuccess(result.data)
                }
                is Resource.Error -> {
                    hideProgressDialog()
                    showErrorSnackBar()
                }
            }
        }.launchIn(viewModelScope)
    }
}
