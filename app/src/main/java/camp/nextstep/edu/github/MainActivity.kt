package camp.nextstep.edu.github

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import camp.nextstep.edu.github.data.remote.module.RepositoryModule
import camp.nextstep.edu.github.databinding.ActivityMainBinding
import camp.nextstep.edu.github.domain.usecase.GithubRepositoryUseCase
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mainViewModel by viewModels<MainViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(
                    GithubRepositoryUseCase(
                        RepositoryModule.getGithubRepository()
                    )
                ) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            lifecycleOwner = this@MainActivity
            viewModel = mainViewModel
            setContentView(root)
        }
        lifecycleScope.launchWhenCreated {
            mainViewModel.eventShowErrorSnackBar.collect {
                Snackbar.make(binding.root, "Error", Snackbar.LENGTH_SHORT).show()
            }
        }
        mainViewModel.loadRepository()
    }
}