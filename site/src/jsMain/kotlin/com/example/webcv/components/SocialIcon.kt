package com.example.webcv.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.graphics.Image
import kotlinx.browser.window
import org.jetbrains.compose.web.css.CSSpxValue
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba

@Composable
internal fun SocialIcon(
    icon: String,
    url: String,
    borderRadius: CSSpxValue
    ) {
    Box(
        modifier = Modifier
            .size(48.px)
            .borderRadius(12.px)
            .backgroundColor(rgba(255, 255, 255, 0.05))
            .cursor(Cursor.Pointer)
            .onClick {
                window.open(url, "_blank")
            }
            .styleModifier {
                property("&:hover", "background-color: rgba(255, 193, 7, 0.1)")
            },
        contentAlignment = Alignment.Center
    ) {
        Image(
            src = icon,
            modifier = Modifier.size(24.px).borderRadius(borderRadius)
        )
    }
}