package camp.nextstep.edu.github

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import camp.nextstep.edu.github.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val githubAdapter: GithubAdapter by lazy {
        GithubAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
        viewModelCallback()
        viewModel.requestGithubRepository()
    }

    private fun viewModelCallback() {
        viewModel.githubList.observe(this) { githubList ->
            githubAdapter.submitList(githubList)
        }
        viewModel.showErrorMessage.observe(this) {
            if (it.consumed) return@observe
            Toast.makeText(this, it.consume(), Toast.LENGTH_SHORT).show()
        }
    }

    private fun initAdapter() {
        binding.recyclerView.adapter = githubAdapter
    }


}