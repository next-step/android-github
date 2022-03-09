package camp.nextstep.edu.github

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.github.domain.Resource
import camp.nextstep.edu.github.domain.model.base.BaseEntity
import kotlinx.coroutines.flow.*

abstract class BaseViewModel : ViewModel() {

    private val _isShowProgress = MutableStateFlow(false)
    val isShowProgress = _isShowProgress.asStateFlow()

    private val _eventShowErrorSnackBar = MutableSharedFlow<Unit>()
    val eventShowErrorSnackBar = _eventShowErrorSnackBar.asSharedFlow()

    protected suspend fun showProgressDialog() {
        _isShowProgress.emit(true)
    }

    protected suspend fun hideProgressDialog() {
        _isShowProgress.emit(false)
    }

    protected suspend fun showErrorSnackBar() {
        _eventShowErrorSnackBar.emit(Unit)
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
