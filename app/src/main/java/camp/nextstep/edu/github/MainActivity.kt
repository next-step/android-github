package camp.nextstep.edu.github

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import camp.nextstep.edu.github.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var resultAdapter: ResultAdapter
    private val viewModel: GithubViewModel by viewModels { GithubViewModelFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        resultAdapter = ResultAdapter()

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = resultAdapter


        viewModel.githubData.observe(this) {
            resultAdapter.submitList(it)
        }

        viewModel.errMessage.observe(this) {
            if (it.consumed) return@observe
            Toast.makeText(this, it.consume(), Toast.LENGTH_LONG).show()
        }

    }
}