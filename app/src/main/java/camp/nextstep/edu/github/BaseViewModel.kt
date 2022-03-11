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

    protected suspend fun showProgress() {
        _isShowProgress.emit(true)
    }

    protected suspend fun hideProgress() {
        _isShowProgress.emit(false)
    }

    protected suspend fun showErrorSnackBar() {
        _eventShowErrorSnackBar.emit(Unit)
    }

    protected fun <T : BaseEntity> Flow<Resource<T>>.handleResultWithState(onSuccess: (T) -> Unit) {
        onEach { result ->
            when (result) {
                is Resource.Loading -> showProgress()
                is Resource.Success -> {
                    hideProgress()
                    onSuccess(result.data)
                }
                is Resource.Error -> {
                    hideProgress()
                    showErrorSnackBar()
                }
            }
        }.launchIn(viewModelScope)
    }
}
