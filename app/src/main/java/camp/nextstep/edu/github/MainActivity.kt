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
import camp.nextstep.edu.github.domain.model.NetworkState
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
        observeErrorEvent()
        observeGithubStorageEvent()

        mainVM.getGithubStorage()
    }

    private fun initRecyclerView() {
        binding.recyclerview.adapter = githubStorageAdapter
    }

    @Suppress("UNCHECKED_CAST")
    private fun observeUIState() = lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            mainVM.uiState.collect { uiState ->
                when (uiState) {
                    is NetworkState.Loading -> {
                        mainVM.updateLoadingEvent(true)
                    }
                    is NetworkState.Success<*> -> {
                        mainVM.updateLoadingEvent(false)
                        mainVM.updateGithubStorage(uiState.data as List<GithubStorage>)
                    }
                    is NetworkState.Error -> {
                        mainVM.updateLoadingEvent(false)
                        mainVM.updateErrorEvent(uiState.throwable)
                    }
                }
            }
        }
    }

    private fun observeErrorEvent() = lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            mainVM.errorEvent.collect { networkState ->
                Toast.makeText(this@MainActivity, networkState.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun observeGithubStorageEvent() = lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            mainVM.githubStorages.collect { githubStorages ->
                githubStorageAdapter.submitList(githubStorages)
            }
        }
    }

}