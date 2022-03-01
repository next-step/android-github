package camp.nextstep.edu.github

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import camp.nextstep.edu.github.databinding.ActivityMainBinding
import com.github.dodobest.data.retrofit.RetrofitManager
import com.github.dodobest.data.utils.RESPONSE_STATE

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGetRepositories.setOnClickListener {
            RetrofitManager.instance.getRepositories {
                responseState, responseBody ->

                when(responseState) {
                    RESPONSE_STATE.OK -> {
                        Toast.makeText(this, "api 호출 완료", Toast.LENGTH_SHORT).show()
                        binding.textRepositories.text = responseBody
                    }
                    RESPONSE_STATE.FAIL -> {
                        Toast.makeText(this, "api 호출 에러", Toast.LENGTH_SHORT).show()
                        binding.textRepositories.text = responseBody
                    }
                }
            }
        }
    }
}