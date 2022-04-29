package theme

import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

object MGColors {
    val colorPrimary = Color(0xFFfdd835)
    val colorAccent = Color(0xFFffff6b)
    val colorDark = Color(0xFFc6a700)
}

val MemoryGameColors = lightColors(
    primary = MGColors.colorPrimary,
    secondary = MGColors.colorAccent,
)