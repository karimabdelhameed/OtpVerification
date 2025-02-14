# OtpVerification

Introducing OtpVerification, a powerful and easy-to-use Android library built with Jetpack Compose for seamless OTP (One-Time Password) verification in your apps. Designed to simplify the implementation of secure authentication flows, this library offers a clean, customizable UI component that integrates effortlessly into your Compose-based projects. 

<img src="https://github.com/karimabdelhameed/OtpVerification/blob/develop/.github/assets/otp_android.png" alt="main">


Key Benefits:  

    Simplified Integration : Effortlessly add OTP verification functionality with minimal code, saving you time and effort.
    Highly Customizable : Fully customize the appearance and behavior of the OTP input fields to match your app's design language.
    Modern UI/UX : Built with Jetpack Compose, ensuring a smooth and responsive user experience on all devices.
    Security-Focused : Provides robust handling of OTP inputs, helping you build secure authentication flows.
    Lightweight & Efficient : Optimized for performance, ensuring no unnecessary overhead in your app.
     

Whether you're building login screens, account recovery flows, or two-factor authentication, OtpVerification makes it easier than ever to implement secure and user-friendly OTP verification in your Android applications. 


## Installation

## OtpConfig Options

| **Property**         | **Type**       | **Default Value**            | **Description**                                                                 |
|-----------------------|----------------|------------------------------|---------------------------------------------------------------------------------|
| `boxCount`           | `Int`          | `6`                          | Number of OTP input boxes (must be greater than 0).                             |
| `boxSize`            | `Dp`           | `48.dp`                      | Size of each OTP input box (width and height).                                  |
| `boxSpacing`         | `Dp`           | `8.dp`                       | Spacing between adjacent OTP input boxes.                                       |
| `boxShape`           | `Shape`        | `RoundedCornerShape(6.dp)`   | Shape of the OTP input boxes (e.g., rounded corners).                           |
| `focusedColor`       | `Color`        | `Color.Blue`                 | Color of the focused OTP input box.                                             |
| `unfocusedColor`     | `Color`        | `Color.Gray`                 | Color of the unfocused OTP input boxes.                                         |
| `errorColor`         | `Color`        | `Color.Red`                  | Color applied when an error occurs (e.g., invalid OTP).                         |
| `textColor`          | `Color`        | `Color.White`                | Text color for the OTP digits.                                                  |
| `backgroundColor`    | `Color`        | `Color.Transparent`          | Background color of the OTP input boxes.                                        |
| `textStyle`          | `TextStyle`    | `TextStyle.Default`          | Style for the text inside the OTP input boxes.                                  |
| `shouldShowCursor`   | `Boolean`      | `false`                      | Whether to display a cursor in the active OTP input box.                        |
| `shouldCursorBlink`  | `Boolean`      | `false`                      | Whether the cursor should blink (if `shouldShowCursor` is `true`).              |
| `errorMessage`       | `String?`      | `null`                       | Error message to display when an error occurs (optional).                       |
| `timerSeconds`       | `Long`         | `60L`                        | Duration of the OTP timer in seconds.                                           |
| `timerTextStyle`     | `TextStyle`    | `TextStyle.Default.copy(color = Color.Black)` | Style for the OTP timer text.                                                   |

---

### Validation

- The `boxCount` property must be greater than `0`. If a value less than or equal to `0` is provided, an exception will be thrown with the message:
  > `"boxCount must be greater than 0"`

---

### Example Usage

Here’s how you might use this configuration in your code:

```kotlin
val otpConfig = OtpConfig(
    boxCount = 6,
    boxSize = 56.dp,
    boxSpacing = 12.dp,
    boxShape = RoundedCornerShape(8.dp),
    focusedColor = Color.Green,
    unfocusedColor = Color.LightGray,
    errorColor = Color.DarkRed,
    textColor = Color.Black,
    backgroundColor = Color.White,
    textStyle = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
    shouldShowCursor = true,
    shouldCursorBlink = true,
    errorMessage = "Invalid OTP",
    timerSeconds = 60L,
    timerTextStyle = TextStyle(fontSize = 16.sp, color = Color.Blue)
)
```

## Sample output
<p float="left">
<img src="https://github.com/karimabdelhameed/OtpVerification/blob/develop/.github/assets/otp_layout.png" width="300" alt="sample1">
<img src="https://github.com/karimabdelhameed/OtpVerification/blob/develop/.github/assets/otp_layout_filled.png" width="300" alt="sample2">
<img src="https://github.com/karimabdelhameed/OtpVerification/blob/develop/.github/assets/otp_layout_error.png" width="300" alt="sample3">
<img src="https://github.com/karimabdelhameed/OtpVerification/blob/develop/.github/assets/otp_video.gif" width="300" alt="sample4">
</p>

## Future plan
<li>Add support for SMS autofill functionaility.</li>
<li>Add support for obscure input (i.e. use * Or similiar instead of real numbers).</li>




## Special thanks 
![@pushpalroy](https://github.com/pushpalroy) for this ![sample repo](https://github.com/pushpalroy/ComposeOtpVerify/tree/main).




## Support
If you like this, maybe consider buying me a coffe ✌️
<a href="https://www.buymeacoffee.com/karimabdelhamed" target="_blank"><img src="https://cdn.buymeacoffee.com/buttons/v2/default-red.png" alt="Buy Me A Coffee" width="150" ></a>

If this repo helped you , you can join the [stargazers](https://github.com/karimabdelhameed/OtpVerification/stargazers) for this repo ⭐

