package camp.nextstep.edu.github.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import camp.nextstep.edu.github.R
import camp.nextstep.edu.github.databinding.ActivityMainBinding
import camp.nextstep.edu.github.domain.model.NetworkState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    private val githubAdapter = GithubAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            lifecycleOwner = this@MainActivity
            vm = mainViewModel
            adapter = githubAdapter
        }
        setContentView(binding.root)
        getGithubRepositories()
        showError()
    }

    private fun getGithubRepositories() {
        mainViewModel.getGithubRepositories()
    }

    private fun showError() {
//        lifecycleScope.launch {
//            repeatOnLifecycle(Lifecycle.State.STARTED) {
//                mainViewModel.sharedFlow.collect {
//                    if (it is NetworkState.Error) {
//                        Toast.makeText(
//                            this@MainActivity,
//                            getString(R.string.fail_network),
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
//                }
//            }
//        }
        mainViewModel.networkLiveEvent.observe(this) {
            if (it is NetworkState.Error) {
                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.fail_network),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
