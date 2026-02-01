package com.example.webcv.pages.contact

import androidx.compose.runtime.Composable
import com.example.webcv.ui.PortfolioColors
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.WhiteSpace
import com.varabyte.kobweb.compose.css.WordBreak
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import kotlinx.browser.window
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgb

@Composable
internal fun ContactItem(icon: String, label: String, value: String, url: String) {
    Row(
        modifier = Modifier.fillMaxWidth().onClick { window.open(url,"_blank") },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.px)
    ) {
        Box(
            modifier = Modifier
                .size(48.px)
                .borderRadius(12.px)
                .backgroundColor(rgb(38, 38, 38))
                .border(1.px, LineStyle.Solid, rgb(50, 50, 50))
                .flexShrink(0),
            contentAlignment = Alignment.Center
        ) {
            Image(
                src = icon,
                modifier = Modifier.size(24.px).color(PortfolioColors.accent),
            )
        }

        Column(
            modifier = Modifier.gap(4.px).fillMaxWidth()
        ) {
            SpanText(
                text = label,
                modifier = Modifier
                    .fontSize(11.px)
                    .color(PortfolioColors.textSecondary)
                    .fontWeight(FontWeight.SemiBold)
                    .letterSpacing(0.5.px)
            )
            SpanText(
                text = value,
                modifier = Modifier
                    .fontSize(14.px)
                    .color(PortfolioColors.textPrimary)
                    .whiteSpace(WhiteSpace.Normal)
                    .wordBreak(WordBreak.BreakAll)
                    .fillMaxWidth()
            )
        }
    }
}