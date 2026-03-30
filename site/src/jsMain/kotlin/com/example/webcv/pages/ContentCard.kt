package com.example.webcv.pages

import androidx.compose.runtime.Composable
import com.example.webcv.components.NavigationTabs
import com.example.webcv.pages.contact.ContactContent
import com.example.webcv.pages.portfolio.PortfolioContent
import com.example.webcv.pages.resume.ResumeContent
import com.example.webcv.ui.PortfolioColors
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px

@OptIn(DelicateApi::class)
@Composable
internal fun ContentCard(activeTab: String, onTabChange: (String) -> Unit) {
    val breakpoint = rememberBreakpoint()
    val isMobile = breakpoint < Breakpoint.MD

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .borderRadius(24.px)
            .background(PortfolioColors.cardBg)
            .border(1.px, LineStyle.Solid, PortfolioColors.borderLight)
            .padding(if (isMobile) 20.px else 48.px)
    ) {
        NavigationTabs(activeTab, onTabChange)
        when (activeTab) {
            "About" -> AboutContent(onNavigateToTab = { onTabChange(it) })
            "Resume" -> ResumeContent()
            "Portfolio" -> PortfolioContent()
            "Contact" -> ContactContent()
        }
    }
}