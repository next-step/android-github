package camp.nextstep.edu.github.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import camp.nextstep.edu.github.main.view.MainScreenContent

@Composable
fun MainScreen(mainViewModel: MainViewModel) {
    MainScreen {
        MainScreenContent(mainViewModel)
    }
}

@Composable
private fun MainScreen(pageContent: @Composable (PaddingValues) -> Unit) {
    Scaffold(
        content = { pageContent.invoke(it) }
    )
}

@Preview(showBackground = true)
@Composable
fun MainPagePreview() {
    MaterialTheme {
        MainScreen {}
    }
}
