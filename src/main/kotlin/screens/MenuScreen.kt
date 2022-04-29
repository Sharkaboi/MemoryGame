package screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import navigation.CurrentRoute
import navigation.Routes
import theme.MGColors

@Composable
fun MenuScreen(
    onClose: () -> Unit
) {
    val currentRoute = CurrentRoute.current
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                "Memory Game",
                color = MGColors.colorDark,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 36.sp
            )
            Text(
                "By Sharkaboi",
                modifier = Modifier.padding(top = 0.dp, bottom = 20.dp)
            )
            Button(
                onClick = {
                    currentRoute.value = Routes.GAME
                },
                modifier = Modifier.padding(20.dp)
            ) {
                Text("Play")
            }
            Button(
                onClick = {
                    currentRoute.value = Routes.SETTINGS
                },
                modifier = Modifier.padding(20.dp)
            ) {
                Text("Settings")
            }
            Button(
                onClick = {
                    onClose()
                },
                modifier = Modifier.padding(20.dp)
            ) {
                Text("Quit")
            }
        }
    }
}