package camp.nextstep.edu.github

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import camp.nextstep.edu.github.databinding.ActivityMainBinding
import com.example.github_data.room.GithubRepoDao
import com.example.github_data.room.GithubRepoDatabase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: GitHubViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initBinding()
        initViewModel()

        setContentView(binding.root)
    }

    private fun initViewModel() {
        val githubRepoDao = GithubRepoDatabase.getInstance(this)!!.GithubRepoDao()
        val githubViewModelFactory = GithubViewModelFactory(githubRepoDao)
        viewModel = ViewModelProvider(this, githubViewModelFactory)[GitHubViewModel::class.java]
        binding.viewModel = viewModel
    }

    private fun initBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
    }
}
