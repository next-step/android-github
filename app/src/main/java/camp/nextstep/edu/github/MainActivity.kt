package camp.nextstep.edu.github

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import camp.nextstep.edu.github.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val gitHubViewModel: GitHubViewModel by viewModels()
    private val gitHubAdapter: GitHubAdapter by lazy { GitHubAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.adapter = gitHubAdapter
        gitHubViewModel.githubs.observe(this) {
            gitHubAdapter.submitList(it)
        }
        gitHubViewModel.fetch()
    }
}
