package com.example.webcv.pages

import androidx.compose.runtime.*
import com.example.webcv.ui.PortfolioColors
import com.varabyte.kobweb.compose.css.disabled
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import kotlinx.browser.window
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.TextArea

@Composable
internal fun ContactContent() {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf(false) }

    // Email validation function
    fun isValidEmail(email: String): Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$".toRegex()
        return email.matches(emailRegex)
    }

    // Check if form is valid
    val isFormValid = fullName.isNotBlank() &&
            email.isNotBlank() &&
            isValidEmail(email) &&
            message.isNotBlank()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.px)
            .gap(32.px)
    ) {


        // Contact Form Section
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .gap(24.px)
        ) {
            Spacer(

            )
            // Full Name and Email Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .gap(20.px)
            ) {
                Input(InputType.Text) {
                    value(fullName)
                    onInput { fullName = it.value }

                    attr("placeholder", "Full name")

                    style {
                        property("flex", "1")
                        property("background-color", "rgba(255, 255, 255, 0.05)")
                        property("border", "1px solid rgba(255, 255, 255, 0.1)")
                        property("border-radius", "12px")
                        property("padding", "16px 20px")
                        property("font-size", "16px")
                        property("font-family", "InterReg")
                        property("color", "#ffffff")
                        property("outline", "none")
                        property("transition", "all 0.3s ease")
                    }

                    style {
                        property("&:focus", "border-color: ${PortfolioColors.accent}; background-color: rgba(255, 255, 255, 0.08);")
                        property("&::placeholder", "color: rgba(255, 255, 255, 0.4);")
                    }
                }

                Column(
                    modifier = Modifier.styleModifier {
                        property("flex", "1")
                    }
                ) {
                    Input(InputType.Email) {
                        value(email)
                        onInput {
                            email = it.value
                            emailError = email.isNotBlank() && !isValidEmail(email)
                        }

                        attr("placeholder", "Email address")

                        style {
                            property("width", "100%")
                            property("background-color", "rgba(255, 255, 255, 0.05)")
                            property("border", if (emailError) "1px solid #ff4444" else "1px solid rgba(255, 255, 255, 0.1)")
                            property("border-radius", "12px")
                            property("padding", "16px 20px")
                            property("font-size", "16px")
                            property("font-family", "InterReg")
                            property("color", "#ffffff")
                            property("outline", "none")
                            property("transition", "all 0.3s ease")
                        }

                        style {
                            property("&:focus", "border-color: ${if (emailError) "#ff4444" else PortfolioColors.accent}; background-color: rgba(255, 255, 255, 0.08);")
                            property("&::placeholder", "color: rgba(255, 255, 255, 0.4);")
                        }
                    }

                    if (emailError) {
                        SpanText(
                            text = "Please enter a valid email address",
                            modifier = Modifier
                                .fontSize(12.px)
                                .backgroundColor(Color("#ff4444"))
                                .padding(top = 4.px, left = 4.px)
                        )
                    }
                }
            }

            // Message TextArea
            TextArea {
                value(message)
                onInput { message = it.value }

                attr("placeholder", "Your Message")
                attr("rows", "8")

                style {
                    property("width", "100%")
                    property("background-color", "rgba(255, 255, 255, 0.05)")
                    property("border", "1px solid rgba(255, 255, 255, 0.1)")
                    property("border-radius", "12px")
                    property("padding", "16px 20px")
                    property("font-size", "16px")
                    property("font-family", "InterReg")
                    property("color", "#ffffff")
                    property("outline", "none")
                    property("resize", "vertical")
                    property("min-height", "150px")
                    property("transition", "all 0.3s ease")
                }

                style {
                    property("&:focus", "border-color: ${PortfolioColors.accent}; background-color: rgba(255, 255, 255, 0.08);")
                    property("&::placeholder", "color: rgba(255, 255, 255, 0.4);")
                }
            }

            // Send Button
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                Button({
                    onClick {
                        if (isFormValid) {
                            // Create mailto link with subject (fullName) and body (message)
                            val subject = js("encodeURIComponent")(fullName) as String
                            val body = js("encodeURIComponent")(message) as String
                            val mailtoLink = "mailto:$email?subject=$subject&body=$body"

                            // Open default email client
                            window.location.href = mailtoLink

                            // Optionally clear the form after sending
                            fullName = ""
                            email = ""
                            message = ""
                            emailError = false
                        }
                    }

                    disabled(!isFormValid)

                    style {
                        property("border", "none")
                        property("border-radius", "12px")
                        property("padding", "14px 32px")
                        property("font-size", "16px")
                        property("font-weight", "600")
                        property("color", if (isFormValid) "#1a1a1a" else "rgba(255, 255, 255, 0.3)")
                        property("cursor", if (isFormValid) "pointer" else "not-allowed")
                        property("display", "flex")
                        property("align-items", "center")
                        property("gap", "8px")
                        property("transition", "all 0.3s ease")
                        property("opacity", if (isFormValid) "1" else "0.5")
                    }

                    if (isFormValid) {
                        style {
                            property("&:hover", "transform: translateY(-2px); box-shadow: 0 8px 16px rgba(255, 193, 7, 0.3);")
                        }
                    }
                }) {
                    SpanText("✈", modifier = Modifier.fontSize(18.px))
                    SpanText("Send Message")
                }
            }
        }
    }
}