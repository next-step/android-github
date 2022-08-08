package camp.nextstep.edu.github.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import camp.nextstep.edu.github.R
import camp.nextstep.edu.github.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val repositoryAdapter: RepositoryAdapter by lazy { RepositoryAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBinding()
        initAdapter()
        initObserver()
        initView()
    }

    private fun initBinding() {
        binding = DataBindingUtil
            .setContentView<ActivityMainBinding>(this, R.layout.activity_main)
            .also {
                it.lifecycleOwner = this
                it.viewModel = viewModel
            }
    }

    private fun initAdapter() {
        binding.rvRepository.adapter = repositoryAdapter
    }

    private fun initObserver() {
        viewModel.repositories.observe(this) {
            repositoryAdapter.submitList(it)
        }
        viewModel.loadingFailed.observe(this) {
            if (!it) return@observe
            showLoadingFailedToast()
        }
    }

    private fun showLoadingFailedToast() {
        Toast
            .makeText(this, R.string.loading_failed, Toast.LENGTH_SHORT)
            .show()
    }

    private fun initView() {
        viewModel.fetchRepositories()
    }
}
