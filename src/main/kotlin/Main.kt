import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import constants.AppConstants
import models.GameState
import navigation.Router
import navigation.Routes
import theme.MemoryGameColors

val CurrentGameState = compositionLocalOf<MutableState<GameState>> {
    error("No game state found!")
}

fun main() = application {
    val window = rememberWindowState(width = 1280.dp, height = 720.dp)
    val gameState = remember { mutableStateOf(GameState()) }
    val gameCounter = remember { mutableStateOf(null) }

    Window(
        onCloseRequest = this::exitApplication,
        title = AppConstants.windowName,
        resizable = true,
        state = window
    ) {
        MaterialTheme(colors = MemoryGameColors) {
            CompositionLocalProvider(CurrentGameState provides gameState) {
                Router(
                    initialRoute = Routes.MENU,
                    closeWindowCallback = {
                        this@application.exitApplication()
                    }
                )
            }
        }
    }
}
