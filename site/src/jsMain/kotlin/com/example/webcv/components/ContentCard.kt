package com.example.webcv.components

import androidx.compose.runtime.Composable
import com.example.webcv.pages.AboutContent
import com.example.webcv.pages.ContactContent
import com.example.webcv.pages.PortfolioContent
import com.example.webcv.pages.ResumeContent
import com.example.webcv.ui.PortfolioColors
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px

@Composable
internal fun ContentCard(activeTab: String, onTabChange: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .borderRadius(24.px)
            .background(PortfolioColors.cardBg)
            .border(1.px, LineStyle.Solid, PortfolioColors.borderLight)
            .padding(48.px)
    ) {
        NavigationTabs(activeTab, onTabChange)
        when (activeTab) {
            "About" -> AboutContent(
                onNavigateToTab = { onTabChange(it) },
            )
            "Resume" -> ResumeContent()
            "Portfolio" -> PortfolioContent()
            "Contact" -> ContactContent()
        }
    }
}