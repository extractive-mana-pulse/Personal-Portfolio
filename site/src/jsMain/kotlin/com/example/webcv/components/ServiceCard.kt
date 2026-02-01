package com.example.webcv.components

import androidx.compose.runtime.Composable
import com.example.webcv.ui.PortfolioColors
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba

@Composable
internal fun ServiceCard(icon: String, title: String, description: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .backgroundColor(rgba(255, 255, 255, 0.03))
            .borderRadius(16.px)
            .padding(24.px)
            .gap(20.px),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(64.px)
                .borderRadius(12.px)
                .backgroundColor(rgba(255, 193, 7, 0.1))
                .border(1.px, LineStyle.Solid, rgba(255, 193, 7, 0.3)),
            contentAlignment = Alignment.Center
        ) {
            SpanText(
                text = icon,
                modifier = Modifier.fontSize(32.px)
            )
        }

        Column(modifier = Modifier.gap(8.px)) {
            SpanText(
                text = title,
                modifier = Modifier
                    .fontSize(20.px)
                    .fontWeight(FontWeight.Bold)
                    .color(PortfolioColors.textPrimary)
            )
            SpanText(
                text = description,
                modifier = Modifier
                    .fontSize(15.px)
                    .lineHeight(1.6)
                    .color(PortfolioColors.textSecondary)
            )
        }
    }
}