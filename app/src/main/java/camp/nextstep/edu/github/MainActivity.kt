package camp.nextstep.edu.github

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import camp.nextstep.edu.github.databinding.ActivityMainBinding
import camp.nextstep.edu.github.domain.error.Error
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var repositoryAdapter: RepositoryAdapter
    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.repositoryAdapter = repositoryAdapter

        viewModel.repositorySate.observe(this, Observer {
            binding.progressCircular.visibility = GONE
            when(it) {
                is RepositoriesState.Failure -> showToast(it.throwable)
                RepositoriesState.Loading -> binding.progressCircular.visibility = VISIBLE
                is RepositoriesState.Success -> repositoryAdapter.submitList(it.repositories)
            }
        })
    }

    private fun showToast(throwable: Throwable) {
        val message: String = when (throwable) {
            Error.NetworkUnavailable -> getString(R.string.network_unavailable_error)
            else ->
                if (throwable.message.isNullOrEmpty()) {
                    getString(R.string.etc_error)
                } else {
                    getString(R.string.etc_error).plus(": ${throwable.message}")
                }
        }
        Toast.makeText(this, message, LENGTH_SHORT).show()
    }
}