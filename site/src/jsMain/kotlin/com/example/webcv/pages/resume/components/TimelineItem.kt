package com.example.webcv.pages.resume.components

import androidx.compose.runtime.Composable
import com.example.webcv.pages.resume.model.ResumeItem
import com.example.webcv.ui.PortfolioColors
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
internal fun TimelineItem(item: ResumeItem, isLast: Boolean) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .position(Position.Relative)
    ) {
        if (!isLast) {
            Box(
                modifier = Modifier
                    .position(Position.Absolute)
                    .top(20.px)
                    .left((-92).px)
                    .width(2.px)
                    .styleModifier {
                        property("height", "calc(100% + 64px)")
                        property("background-color", "rgba(234, 179, 8, 0.4)")
                    }
            )
        }
        Box(
            modifier = Modifier
                .position(Position.Absolute)
                .top(4.px)
                .left((-101).px)
                .size(18.px)
                .borderRadius(50.percent)
                .backgroundColor(PortfolioColors.accent)
                .styleModifier {
                    property("border", "4px solid rgba(24, 24, 27, 1)")
                    property("box-shadow", "0 0 0 1px rgba(234, 179, 8, 0.5)")
                }
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .gap(12.px)
        ) {
            SpanText(
                text = item.title,
                modifier = Modifier
                    .fontSize(22.px)
                    .fontWeight(FontWeight.Bold)
                    .color(PortfolioColors.textPrimary)
                    .lineHeight(1.4)
            )
            SpanText(
                text = item.period,
                modifier = Modifier
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Medium)
                    .color(PortfolioColors.accent)
                    .lineHeight(1.3)
            )
            SpanText(
                text = item.description,
                modifier = Modifier
                    .fontSize(17.px)
                    .fontWeight(FontWeight.Normal)
                    .color(PortfolioColors.textSecondary)
                    .lineHeight(1.6)
                    .opacity(0.85)
            )
        }
    }
}