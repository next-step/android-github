package camp.nextstep.edu.github

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import camp.nextstep.edu.github.databinding.ActivityMainBinding
import camp.nextstep.edu.github.domain.model.GithubStorage
import camp.nextstep.edu.github.model.UIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainVM: MainViewModel by viewModels()

    @Inject
    lateinit var githubStorageAdapter: GithubStorageAdapter

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            lifecycleOwner = this@MainActivity
            mainVM = this@MainActivity.mainVM
        }
        setContentView(binding.root)

        initRecyclerView()
        observeUIState()
        mainVM.getGithubStorage()
    }

    private fun initRecyclerView() {
        binding.recyclerview.adapter = githubStorageAdapter
    }

    private fun observeUIState() = lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            mainVM.uiState.collect { uiState ->
                when (uiState) {
                    is UIState.Loading -> {}
                    is UIState.Success<*> -> {
                        @Suppress("UNCHECKED_CAST")
                        githubStorageAdapter.submitList(uiState.data as List<GithubStorage>)
                    }
                    is UIState.Error -> {
                        showToast(uiState.throwable.message)
                    }
                }
            }
        }
    }

    private fun showToast(message: String?) {
        if (message != null) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }
}