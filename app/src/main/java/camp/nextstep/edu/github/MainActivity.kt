package camp.nextstep.edu.github

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import camp.nextstep.edu.github.MainViewModel.ViewEvent
import camp.nextstep.edu.github.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private val gitRepoAdapter by lazy { GitRepoAdapter() }
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initList()
        initViewEvent()
    }

    private fun initList() {
        with(binding.list) {
            itemAnimator = null
            adapter = gitRepoAdapter
        }
        viewModel.repos.observe(this) {
            gitRepoAdapter.submitList(it)
        }
    }

    private fun initViewEvent() {
        viewModel.viewEvent.observe(this) {
            when (it) {
                ViewEvent.GitRepoLoadingFailure -> Toast.makeText(
                    this,
                    "fail loading git repos",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
