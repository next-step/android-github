package camp.nextstep.edu.github

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import camp.nextstep.edu.github.databinding.ActivityMainBinding
import camp.nextstep.edu.github.model.UIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    private val githubStorageAdapter: GithubStorageAdapter by lazy { GithubStorageAdapter() }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            lifecycleOwner = this@MainActivity
            mainViewModel = this@MainActivity.mainViewModel
        }
        setContentView(binding.root)

        initRecyclerView()
        observeUIState()
        mainViewModel.loadGithubStorage()
    }

    private fun initRecyclerView() {
        binding.recyclerview.adapter = githubStorageAdapter
    }

    private fun observeUIState() = lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            mainViewModel.uiState.collect { uiState ->
                when (uiState) {
                    is UIState.Loading -> {
                        showLoading(true)
                    }
                    is UIState.Success -> {
                        showLoading(false)
                        githubStorageAdapter.submitList(uiState.data)
                    }
                    is UIState.Error -> {
                        showLoading(false)
                        showToast(uiState.throwable.message)
                    }
                }
            }
        }
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressbar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    private fun showToast(message: String?) {
        if (message != null) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }
}