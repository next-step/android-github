package camp.nextstep.edu.github

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import camp.nextstep.edu.github.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpBinding()
        setUpGithubRepositoryList()
        viewModel.loadRepositoryResponse()
    }

    private fun setUpBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner = this@MainActivity
    }

    private fun setUpGithubRepositoryList() {
        val adapter = RepositoryListAdapter()
        binding.recyclerView.adapter = adapter
        viewModel.repositoryResponseList.observe(this@MainActivity, adapter::submitList)

        viewModel.errorMessage.observe(this@MainActivity){
            binding.textViewError.visibility = View.VISIBLE
            binding.textViewError.text = it
        }
    }
}