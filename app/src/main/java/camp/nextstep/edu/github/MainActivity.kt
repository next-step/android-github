package camp.nextstep.edu.github

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import camp.nextstep.edu.github.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels { ViewModelFactory() }
    private val githubAdapter = GithubAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        setAdapter()
        getGithubRepositories()
        observeGithubRepositories()
        observeNetworkState()
    }

    private fun observeNetworkState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                mainViewModel.networkState.collect {
                    if (!it) Toast.makeText(
                        this@MainActivity,
                        getString(R.string.fail_network),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun observeGithubRepositories() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                mainViewModel.githubRepositories.collect {
                    githubAdapter.submitList(it)
                }
            }
        }
    }

    private fun getGithubRepositories() {
        mainViewModel.getGithubRepositories()
    }

    private fun setAdapter() {
        binding.rvMain.adapter = githubAdapter
    }
}