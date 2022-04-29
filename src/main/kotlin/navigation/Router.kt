package navigation

import androidx.compose.runtime.*
import screens.MemoryGameScreen
import screens.MenuScreen
import screens.PauseScreen
import screens.SettingsScreen

val CurrentRoute = compositionLocalOf<MutableState<Routes>> {
    error("No route found!")
}

@Composable
fun Router(initialRoute: Routes, closeWindowCallback: () -> Unit) {
    val currentRoute = remember { mutableStateOf(initialRoute) }

    CompositionLocalProvider(CurrentRoute provides currentRoute) {
        when (currentRoute.value) {
            Routes.MENU -> MenuScreen(closeWindowCallback)
            Routes.GAME -> MemoryGameScreen()
            Routes.SETTINGS -> SettingsScreen()
            Routes.PAUSE -> PauseScreen()
        }
    }
}