package camp.nextstep.edu.github.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import camp.nextstep.edu.github.R
import camp.nextstep.edu.github.databinding.ActivityGithubBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GithubActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGithubBinding
    private val viewModel: GithubViewModel by viewModels()
    private val repositoryAdapter by lazy { RepositoryAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGithubBinding.inflate(layoutInflater).apply {
            viewmodel = viewModel
            lifecycleOwner = this@GithubActivity
        }
        setContentView(binding.root)
        initAdapter()
        observeRepositories()
        observeError()

        viewModel.getRepositories()
    }

    private fun initAdapter() {
        binding.recyclerView.adapter = repositoryAdapter
    }

    private fun observeRepositories() {
        viewModel.repositories.observe(this) {
            repositoryAdapter.submitList(it)
        }
    }

    private fun observeError() {
        viewModel.errorEvent.observe(this) {
            Toast.makeText(this, getString(R.string.unknown_error), Toast.LENGTH_SHORT).show()
        }
    }
}
