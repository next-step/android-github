package camp.nextstep.edu.github

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

object ActivityMain {

    @Composable
    fun Layout() {
        MaterialTheme { Scaffold() }
    }

    @Composable
    private fun Scaffold() {
        Scaffold(
            content = { Content() }
        )
    }

    @Composable
    private fun Content() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Hello World!")
        }
    }
}
