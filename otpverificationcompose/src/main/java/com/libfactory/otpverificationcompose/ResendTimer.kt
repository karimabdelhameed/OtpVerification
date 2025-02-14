package com.libfactory.otpverificationcompose

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import kotlinx.coroutines.delay

@Composable
fun ResendTimer(
    initialTimer: Int,
    config: OtpConfig,
    onResend: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var remainingTime by remember { mutableIntStateOf(initialTimer) }
    var timerActive by remember { mutableStateOf(true) }

    LaunchedEffect(key1 = timerActive) {
        while (remainingTime > 0 && timerActive) {
            delay(1000)
            remainingTime--
        }
        timerActive = false
    }

    Row(modifier = modifier) {
        if (timerActive) {
            Text(
                text = "Resend code in ${remainingTime}s",
                style = config.timerTextStyle
            )
        } else {
            TextButton(
                onClick = {
                    remainingTime = initialTimer
                    timerActive = true
                    onResend()
                },
                enabled = timerActive.not()
            ) {
                Text(
                    text = "Resend Code",
                    style = config.timerTextStyle
                )
            }
        }
    }
}