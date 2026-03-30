package com.example.webcv.pages

import androidx.compose.runtime.*
import com.example.webcv.components.ProfileCard
import com.example.webcv.ui.PortfolioColors
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgb

@OptIn(DelicateApi::class)
@Page
@Composable
fun HomePage() {
    var activeTab by remember { mutableStateOf("About") }
    val breakpoint = rememberBreakpoint()
    val isMobile = breakpoint < Breakpoint.MD

    Column(
        Modifier
            .fillMaxSize()
            .background(PortfolioColors.background)
            .padding(if (isMobile) 16.px else 40.px)
    ) {
        SpanText(
            text = "We're still putting on the finishing touches! ✨ Check back soon for the official reveal!",
            modifier = Modifier
                .fillMaxWidth()
                .color(rgb(150, 150, 150))
                .margin(bottom = 24.px)
        )

        Box(
            Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            if (isMobile) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(24.px)
                ) {
                    ProfileCard(fullWidth = true)
                    ContentCard(activeTab) { activeTab = it }
                }
            } else {
                Row(
                    modifier = Modifier
                        .maxWidth(1200.px)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(32.px),
                    verticalAlignment = Alignment.Top
                ) {
                    ProfileCard(fullWidth = false)
                    ContentCard(activeTab) { activeTab = it }
                }
            }
        }
    }
}