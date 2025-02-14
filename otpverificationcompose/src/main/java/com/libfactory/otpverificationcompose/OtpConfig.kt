package com.libfactory.otpverificationcompose

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class OtpConfig(
    // Layout
    val boxCount: Int = 6,
    val boxSize: Dp = 48.dp,
    val boxSpacing: Dp = 8.dp,
    val boxShape: Shape = RoundedCornerShape(6.dp),

    // Colors
    val focusedColor: Color = Color.Blue,
    val unfocusedColor: Color = Color.Gray,
    val errorColor: Color = Color.Red,
    val textColor: Color = Color.White,
    val backgroundColor: Color = Color.Transparent,

    // Text
    val textStyle: TextStyle = TextStyle.Default,

    // Future use?
    // If the OTP is obscured
    val obscureText: Boolean = false,
    val obscureCharacter: Char = '•',

    // Cursor
    val shouldShowCursor: Boolean = false,
    val shouldCursorBlink: Boolean = false,

    // error
    val errorMessage: String? = null,

    // Timer
    val timerSeconds: Long = 60L,
    val timerTextStyle: TextStyle = TextStyle.Default.copy(color = Color.Black),
) {
    init {
        require(boxCount > 0) { "boxCount must be greater than 0" }
    }
}