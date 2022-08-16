package camp.nextstep.edu.github

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import camp.nextstep.edu.github.adapter.RepositoryAdapter
import camp.nextstep.edu.github.databinding.ActivityMainBinding
import camp.nextstep.edu.github.domain.GithubRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mainViewModel by viewModels<MainViewModel>()

    private val repositoryAdapter = RepositoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initAdapter()
        bindView()
        observeData()
    }

    private fun initAdapter() {
        binding.repositoryRecyclerView.adapter = repositoryAdapter
    }

    private fun bindView() {
        binding.retryButton.setOnClickListener {
            mainViewModel.fetchRepositories()
        }
    }

    private fun observeData() {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                mainViewModel.repositories.collect { uiState: UiState<List<GithubRepository>> ->
                    binding.progressBar.isVisible = uiState is UiState.Loading
                    binding.errorGroup.isVisible = uiState is UiState.Error
                    when (uiState) {
                        is UiState.Success -> handleSuccess(uiState.data)
                        is UiState.Error -> handleError(uiState.throwable)
                    }
                }
            }
        }
    }

    private fun handleSuccess(data: List<GithubRepository>?) {
        repositoryAdapter.submitList(data)
    }

    private fun handleError(throwable: Throwable?) {
        Toast.makeText(applicationContext, "${throwable?.message}", Toast.LENGTH_SHORT).show()
    }

}