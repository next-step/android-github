package camp.nextstep.edu.github

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import camp.nextstep.edu.github.databinding.ActivityMainBinding
import camp.nextstep.edu.github.view.RecyclerViewAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val adapter: RecyclerViewAdapter by lazy {
        RecyclerViewAdapter()
    }

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observe()
        setView()
    }

    private fun setView() {
        binding.recyclerview.adapter = adapter
        viewModel.getGitHubRepository()
    }

    private fun observe() {
        with(viewModel) {
            items.observe(this@MainActivity) {
                adapter.submitList(it)
            }
            errorMsg.observe(this@MainActivity) {
                Toast.makeText(this@MainActivity, "네트워크 연결이 되지 않습니다", Toast.LENGTH_SHORT).show()
            }
        }
    }
}