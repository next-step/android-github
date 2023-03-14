package camp.nextstep.edu.github

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import camp.nextstep.edu.github.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var searchAdapter: RepositoriesSearchAdapter

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        setupRecyclerView()
        observerLiveData()
        searchRepository()
    }

    private fun initView() {
        binding.lifecycleOwner = this
        binding.vm = viewModel
    }

    private fun searchRepository() {
        viewModel.searchRepositories()
    }

    private fun setupRecyclerView() {
        searchAdapter = RepositoriesSearchAdapter()
        with(binding.rvSearchResult) {
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = searchAdapter
        }
    }

    private fun observerLiveData() {
        viewModel.repositories.observe(this) {
            searchAdapter.submitList(it.toList())
        }
    }
}
