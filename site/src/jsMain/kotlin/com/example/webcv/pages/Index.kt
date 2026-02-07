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
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgb

@Page
@Composable
fun HomePage() {

    var activeTab by remember { mutableStateOf("About") }

    Column(
        Modifier
            .fillMaxSize()
            .background(PortfolioColors.background)
            .padding(40.px)
    ) {

        SpanText(
            text = "We're still putting on the finishing touches! ✨ The images you see here are pre-final versions while our site is under construction. Check back soon for the official reveal!",
            modifier = Modifier
                .fillMaxWidth()
                .color(rgb(150, 150, 150))
                .margin(bottom = 24.px)
        )

        Box(
            Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .maxWidth(1200.px)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(32.px),
                verticalAlignment = Alignment.Top
            ) {
                ProfileCard()
                ContentCard(activeTab) { activeTab = it }
            }
        }
    }
}