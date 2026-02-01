package com.example.webcv.pages

import androidx.compose.runtime.Composable
import com.example.webcv.ui.PortfolioColors
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.px

@Composable
internal fun PortfolioContent() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.px),
        contentAlignment = Alignment.Center
    ) {
        SpanText(
            text = "Portfolio content coming soon...",
            modifier = Modifier
                .fontSize(20.px)
                .color(PortfolioColors.textSecondary)
        )
    }
}
