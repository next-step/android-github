/**
 * @author Daewon on 02,September,2023
 *
 */

package camp.nextstep.edu.github.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LoadingScreen(modifier: Modifier) {
    Surface(modifier = modifier) {
        CircularProgressIndicator()
    }
}
