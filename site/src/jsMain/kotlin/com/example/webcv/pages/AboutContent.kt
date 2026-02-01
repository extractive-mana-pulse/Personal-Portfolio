package com.example.webcv.pages

import androidx.compose.runtime.Composable
import com.example.webcv.components.InfoBullet
import com.example.webcv.ui.PortfolioColors
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.px

@Composable
internal fun AboutContent(
    onNavigateToTab: (String) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .margin(top = 32.px)
            .gap(32.px)
    ) {
        Column(modifier = Modifier.gap(16.px)) {
            SpanText(
                text = "Software Engineer | Android developer with 4+ years of experience | algorithmic problems solving mindset. Committed to continuous learning in the rapidly evolving mobile technology landscape.",
                modifier = Modifier
                    .fontSize(16.px)
                    .lineHeight(1.8)
                    .fontFamily("InterReg")
                    .color(PortfolioColors.textSecondary)
            )
            InfoBullet("icons/laptop.svg", "Currently building technically challenging and innovative projects.")
            InfoBullet("icons/handshake.svg", "Open to collaborating with developers on innovative and meaningful projects.")
            InfoBullet(
                icon = "icons/forum.svg",
                text = "You have any questions ? Feel free to reach me out in Contact Section.",
                onContactClick = { onNavigateToTab("Contact") }
            )
        }
    }
}