package com.libfactory.otpverificationcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp

/**
 * A composable function for creating OTP component.
 *
 * This OTP input field allows for the entry of a One Time Password (OTP) with a configurable number of characters.
 *
 * @param modifier Modifier for styling and layout of the component.
 * @param config config object to control UI for otp component.
 * @param onOtpModified Lambda function that is triggered when the OTP text changes.
 *                      It provides the updated text and a flag indicating if the OTP is complete.
 * @param onResendClicked Lambda function that is triggered when resend OTP is clicked.
 * @param validation Lambda function to validate the OTP text & show error accordingly.
 */
@Composable
fun OtpComponent(
    modifier: Modifier = Modifier,
    config: OtpConfig = OtpConfig(),
    onOtpModified: (String, Boolean) -> Unit,
    onResendClicked: () -> Unit,
    validation: (String) -> Boolean = { true },
) {
    var otpValue by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var isResendEnabled by remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current


    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
        keyboardController?.show()
    }


    LaunchedEffect(otpValue) {
        errorMessage =
            if (otpValue.isNotEmpty() && otpValue.length == config.boxCount && !validation(otpValue)) {
                config.errorMessage
            } else {
                null
            }
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // OTP Input Field
        OtpInputField(
            modifier = Modifier
                .padding(top = 48.dp)
                .focusRequester(focusRequester),
            otpText = otpValue,
            onOtpModified = { value, otpFilled ->
                otpValue = value
                onOtpModified.invoke(value, otpFilled)
                if (otpFilled) {
                    keyboardController?.hide()
                }
            },
            isError = errorMessage != null,
            config = config
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Error message text
        errorMessage?.let { msg ->
            Text(
                text = msg,
                style = config.textStyle,
                color = config.errorColor,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Resend Timer
        ResendTimer(
            initialTimer = config.timerSeconds.toInt(),
            config = config,
            onResend = {
                isResendEnabled = false
                otpValue = ""
                errorMessage = null
                onResendClicked.invoke()
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}