package com.example.webcv.components

import androidx.compose.runtime.Composable
import com.example.webcv.ui.PortfolioColors
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.px

@Composable
internal fun InfoBullet(icon: String, text: String, onContactClick: (() -> Unit)? = null) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .gap(12.px),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            src = icon,
            modifier = Modifier.size(24.px)
        )

        // Split the text if there's a clickable part
        if (onContactClick != null && text.contains("Contact")) {
            val parts = text.split("Contact")
            Row(
                modifier = Modifier
                    .fontSize(16.px)
                    .lineHeight(1.8)
                    .fontFamily("InterReg")
                    .color(PortfolioColors.textSecondary),
                verticalAlignment = Alignment.CenterVertically
            ) {
                SpanText(text = parts[0])
                SpanText(
                    text = "Contact",
                    modifier = Modifier
                        .color(PortfolioColors.accent)
                        .cursor(Cursor.Pointer)
                        .textDecorationLine(TextDecorationLine.Underline)
                        .onClick { onContactClick() }
                )
                if (parts.size > 1) {
                    SpanText(text = parts[1])
                }
            }
        } else {
            SpanText(
                text = text,
                modifier = Modifier
                    .fontSize(16.px)
                    .lineHeight(1.8)
                    .fontFamily("InterReg")
                    .color(PortfolioColors.textSecondary)
            )
        }
    }
}