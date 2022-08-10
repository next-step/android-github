package camp.nextstep.edu.github

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import camp.nextstep.edu.github.data.DataInjector
import camp.nextstep.edu.github.domain.Repo


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}