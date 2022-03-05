package camp.nextstep.edu.github.utils

import android.view.View
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import camp.nextstep.edu.github.R
import camp.nextstep.edu.github.domain.model.Github
import camp.nextstep.edu.github.domain.model.NetworkState
import camp.nextstep.edu.github.ui.GithubAdapter

object BindingAdapters {
    @JvmStatic
    @BindingAdapter("toast")
    fun View.bindToast(networkState: NetworkState) {
        if (networkState is NetworkState.Error) {
            Toast.makeText(context, context.getString(R.string.fail_network), Toast.LENGTH_SHORT)
                .show()
        }
    }

    @JvmStatic
    @BindingAdapter("adapter")
    fun RecyclerView.bindAdapter(adapter: RecyclerView.Adapter<*>) {
        this.adapter = adapter
    }

    @Suppress("UNCHECKED_CAST")
    @JvmStatic
    @BindingAdapter("githubItems")
    fun RecyclerView.bindGithubRepositories(networkState: NetworkState) {
        val boundAdapter = this.adapter
        if (boundAdapter is GithubAdapter && networkState is NetworkState.Success<*>) {
            boundAdapter.submitList(networkState.data as List<Github>)
        }
    }
}
