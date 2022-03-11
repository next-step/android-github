package camp.nextstep.edu.github.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import camp.nextstep.edu.github.domain.model.Github
import camp.nextstep.edu.github.domain.model.NetworkState
import camp.nextstep.edu.github.ui.GithubAdapter
import kotlinx.coroutines.flow.StateFlow

object BindingAdapters {
//    @JvmStatic
//    @BindingAdapter("toast")
//    suspend fun View.bindToast(networkState: EventFlow<NetworkState>) {
//        networkState.collect{
//            if(it is NetworkState.Error){
//                Toast.makeText(context, context.getString(R.string.fail_network), Toast.LENGTH_SHORT)
//                    .show()
//            }
//        }
    //        if (networkState is NetworkState.Error) {
    //            Toast.makeText(context, context.getString(R.string.fail_network), Toast.LENGTH_SHORT)
    //                .show()
    //        }
//    }

    @JvmStatic
    @BindingAdapter("adapter")
    fun RecyclerView.bindAdapter(adapter: RecyclerView.Adapter<*>) {
        this.adapter = adapter
    }

    @Suppress("UNCHECKED_CAST")
    @JvmStatic
    @BindingAdapter("githubItems")
    fun RecyclerView.bindGithubRepositories(networkState: StateFlow<NetworkState>) {
        val boundAdapter = this.adapter
        if (boundAdapter is GithubAdapter && networkState.value is NetworkState.Success<*>) {
            boundAdapter.submitList((networkState.value as NetworkState.Success<*>).data as List<Github>)
        }
    }
}
