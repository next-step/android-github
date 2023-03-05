package camp.nextstep.edu.github

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import camp.nextstep.edu.github.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: RepositoryViewModel by viewModels()
    private val adapter = RepositoryAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        observeRepositories()
        observeException()
    }

    private fun init() {
        binding.lifecycleOwner = this
        binding.recyclerView.adapter = adapter
    }

    private fun observeRepositories() {
        viewModel.repositories.observe(this) {
            adapter.submitList(it)
        }
    }

    private fun observeException() {
        viewModel.exception.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }
}
