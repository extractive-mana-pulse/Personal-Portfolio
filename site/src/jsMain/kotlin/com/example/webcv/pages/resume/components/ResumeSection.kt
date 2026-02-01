package com.example.webcv.pages.resume.components

import androidx.compose.runtime.Composable
import com.example.webcv.pages.resume.model.ResumeItem
import com.example.webcv.ui.PortfolioColors
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.px

@Composable
internal fun ResumeSection(
    title: String,
    icon: String,
    items: List<ResumeItem>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .gap(40.px),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier
                .gap(20.px),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(72.px)
                    .borderRadius(20.px)
                    .backgroundColor(PortfolioColors.cardBg)
                    .styleModifier {
                        property("border", "1px solid rgba(255, 255, 255, 0.1)")
                    },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    src = icon,
                    modifier = Modifier.size(24.px)
                )
            }

            SpanText(
                text = title,
                modifier = Modifier
                    .fontSize(40.px)
                    .fontWeight(FontWeight.Bold)
                    .color(PortfolioColors.textPrimary)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .position(Position.Relative)
                .padding(left = 128.px)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .gap(64.px)
            ) {
                items.forEachIndexed { index, item ->
                    TimelineItem(item, isLast = index == items.lastIndex)
                }
            }
        }
    }
}