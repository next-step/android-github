package camp.nextstep.edu.github

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import camp.nextstep.edu.github.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels(factoryProducer = ::ViewModelFactory)
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpBinding()
        setUpGithubRepositoryList()
        viewModel.loadRepositoryData()
    }

    private fun setUpBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setUpGithubRepositoryList() {
        val adapter = RepositoryListAdapter()
        binding.recyclerView.adapter = adapter
        viewModel.repositoryData.observe(this@MainActivity, adapter::submitList)
    }
}