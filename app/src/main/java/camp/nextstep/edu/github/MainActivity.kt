package camp.nextstep.edu.github

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import camp.nextstep.edu.github.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mainViewModel by viewModels<MainViewModel>()

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