package com.libFactory.otpverificationcomposetest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.libFactory.otpverificationcomposetest.ui.theme.OtpVerificationComposeTestTheme
import com.libfactory.otpverificationcompose.OtpComponent
import com.libfactory.otpverificationcompose.OtpConfig
import com.libfactory.otpverificationcompose.OtpInputField

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OtpVerificationComposeTestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                    TestOtp(modifier = Modifier.padding(padding))
                }
            }
        }
    }
}

@Composable
fun TestOtp(modifier: Modifier = Modifier) {
    var otpValue by remember { mutableStateOf("") }
    var isOtpFilled by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, top = 40.dp),
            text = "Please verify your phone number with the OTP we sent to t**t@domain.com",
            style = MaterialTheme.typography.bodyMedium,
            color = androidx.compose.ui.graphics.Color.Blue,
            textAlign = TextAlign.Center
        )
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .background(androidx.compose.ui.graphics.Color.White)
                .padding(24.dp),
            color = androidx.compose.ui.graphics.Color.White
        ) {
            OtpComponent(
                modifier = Modifier.fillMaxWidth(),
                config = OtpConfig(
                    timerSeconds = 30L,
                    errorMessage = "Invalid OTP",
                ),
                onOtpModified = { value, otpFilled ->
                    otpValue = value
                    isOtpFilled = otpFilled
                    if (otpFilled) {
                        // call API to verify OTP?
                    }
                },
                onResendClicked = {
                    // call API to resend OTP?
                    Log.d("Resend", "Resend clicked")
                },
                validation = {
                    // add your custom validation logic here
                    it == "123456" // if OTP is anything other than 123456, it will show error message
                }
            )
        }
    }
}