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
    private val listAdapter = RepositoryListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            lifecycleOwner = this@MainActivity
            viewModel = this@MainActivity.viewModel
        }
        setContentView(binding.root)

        initAdapter()
        viewModel.getGitHubRepositoryList()
        showRepositoryList()
        showErrorMessage()
    }

    private fun initAdapter() {
        binding.rvRepository.adapter = listAdapter
    }

    private fun showRepositoryList() {
        viewModel.gitHubRepositoryItemList.observe(this) {
            listAdapter.submitList(it)
        }
    }

    private fun showErrorMessage() {
        viewModel.errorMessage.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }
}