package com.example.webcv.components

import androidx.compose.runtime.Composable
import com.example.webcv.ui.PortfolioColors
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.px

@Composable
internal fun NavigationTabs(activeTab: String, onTabChange: (String) -> Unit) {
    // Generate title based on active tab
    val pageTitle = when (activeTab) {
        "About" -> "About Me"
        "Resume" -> "Resume"
        "Portfolio" -> "Portfolio"
        "Contact" -> "Contact Form"
        else -> "About Me"
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .gap(8.px),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            SpanText(
                text = pageTitle,
                modifier = Modifier
                    .fontSize(36.px)
                    .fontWeight(FontWeight.Bold)
                    .color(PortfolioColors.textPrimary)
            )
            Box(
                modifier = Modifier
                    .width(60.px)
                    .height(4.px)
                    .backgroundColor(PortfolioColors.accent)
                    .borderRadius(2.px)
            )
        }

        Row(
            modifier = Modifier.gap(8.px),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            listOf("About", "Resume", "Portfolio", "Contact").forEach { tab ->
                TabButton(
                    text = tab,
                    isActive = activeTab == tab,
                    onClick = { onTabChange(tab) }
                )
            }
        }
    }
}