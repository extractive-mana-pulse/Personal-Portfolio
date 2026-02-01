package com.example.webcv.pages.portfolio.components

import androidx.compose.runtime.Composable
import com.example.webcv.ui.PortfolioColors
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.px

@Composable
internal fun PortfolioFilterTab(text: String, isActive: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .padding(12.px, 8.px)
            .cursor(Cursor.Pointer)
            .onClick { onClick() }
    ) {
        SpanText(
            text = text,
            modifier = Modifier
                .fontSize(16.px)
                .fontWeight(if (isActive) FontWeight.SemiBold else FontWeight.Normal)
                .color(if (isActive) PortfolioColors.accent else PortfolioColors.textSecondary)
        )
    }
}