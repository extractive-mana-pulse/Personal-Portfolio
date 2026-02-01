package com.example.webcv.pages

import androidx.compose.runtime.*
import com.example.webcv.components.ContentCard
import com.example.webcv.components.ProfileCard
import com.example.webcv.ui.PortfolioColors
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.css.px


@Page
@Composable
fun HomePage() {

    var activeTab by remember { mutableStateOf("About") }

    Box(
        Modifier
            .fillMaxSize()
            .background(PortfolioColors.background)
            .padding(40.px),
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