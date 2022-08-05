package camp.nextstep.edu.github

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import camp.nextstep.edu.github.databinding.ActivityMainBinding
import camp.nextstep.edu.github.githubListAdapter.GithubListAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var githubListAdapter: GithubListAdapter
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        setRecyclerView()
    }

    private fun setRecyclerView() {
        githubListAdapter = GithubListAdapter()
        binding.recyclerView.adapter = githubListAdapter
        //githubListAdapter.submitList(listOf(Github("jinhong","testtest"),Github("jinhong","testtest")))
    }

    private fun setupViewModel() {

    }
}