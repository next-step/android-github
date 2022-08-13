package camp.nextstep.edu.github.ui.base

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import camp.nextstep.edu.github.ui.theme.DarkColorPalette
import camp.nextstep.edu.github.ui.theme.LightColorPalette

fun ComponentActivity.setThemeContent(content: @Composable () -> Unit) = setContent {
    val colors = if (isSystemInDarkTheme()) DarkColorPalette else LightColorPalette

    MaterialTheme(colors = colors, content = content)
}