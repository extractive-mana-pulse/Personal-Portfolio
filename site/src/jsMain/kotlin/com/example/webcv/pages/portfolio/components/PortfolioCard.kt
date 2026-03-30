package com.example.webcv.pages.portfolio.components

import androidx.compose.runtime.*
import com.example.webcv.pages.portfolio.model.PortfolioItem
import com.example.webcv.ui.PortfolioColors
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.graphics.ImageFetchPriority
import com.varabyte.kobweb.silk.components.text.SpanText
import kotlinx.browser.window
import org.jetbrains.compose.web.css.*

@Composable
internal fun PortfolioCard(item: PortfolioItem) {
    var isHovered by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .styleModifier { property("width", "calc((100% - 24px) / 2)") }
            .minWidth(260.px)
            .borderRadius(16.px)
            .border(1.px, LineStyle.Solid, PortfolioColors.border)
            .overflow(Overflow.Hidden)
            .background(PortfolioColors.cardBg)
            .cursor(Cursor.Pointer)
            .styleModifier {
                property("transition", "transform 0.25s ease, border-color 0.25s ease")
                if (isHovered) {
                    property("transform", "translateY(-4px)")
                    property("border-color", "rgba(255,193,7,0.5)")
                }
            }
            .onMouseEnter { isHovered = true }
            .onMouseLeave { isHovered = false }
            .onClick { window.open(item.url, "_blank") }
    ) {
        // Image with aspect ratio
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .styleModifier { property("aspect-ratio", "16/9") }
                .overflow(Overflow.Hidden)
                .position(Position.Relative),
            contentAlignment = Alignment.Center
        ) {
            Image(
                src = item.imageUrl,
                modifier = Modifier
                    .fillMaxSize()
                    .objectFit(ObjectFit.Contain)
                    .styleModifier {
                        property("transition", "transform 0.35s ease")
                        if (isHovered) property("transform", "scale(1.06)")
                    },
                fetchPriority = ImageFetchPriority.High
            )

            // Hover overlay
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .styleModifier {
                        property("background", "rgba(0,0,0,0.45)")
                        property("opacity", if (isHovered) "1" else "0")
                        property("transition", "opacity 0.25s ease")
                    },
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(48.px)
                        .borderRadius(50.percent)
                        .backgroundColor(rgba(255, 255, 255, 0.95)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        src = "/icons/preview.svg",
                        modifier = Modifier
                            .size(20.px)
                            .styleModifier { property("filter", "brightness(0.2)") }
                    )
                }
            }
        }

        // Card footer
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.px)
                .gap(8.px)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().gap(8.px),
                verticalAlignment = Alignment.CenterVertically
            ) {
                SpanText(
                    text = item.title,
                    modifier = Modifier
                        .fontSize(16.px)
                        .fontWeight(FontWeight.SemiBold)
                        .color(PortfolioColors.textPrimary)
                        .styleModifier { property("flex", "1") }
                )
                SpanText(
                    text = item.platforms.joinToString(" · "),
                    modifier = Modifier
                        .fontSize(11.px)
                        .fontWeight(FontWeight.Medium)
                        .color(PortfolioColors.accent)
                        .backgroundColor(rgba(255, 193, 7, 0.12))
                        .borderRadius(6.px)
                        .padding(topBottom = 3.px, leftRight = 8.px)
                        .styleModifier { property("white-space", "nowrap") }
                )
            }

            if (item.description.isNotEmpty()) {
                SpanText(
                    text = item.description,
                    modifier = Modifier
                        .fontSize(13.px)
                        .color(PortfolioColors.textSecondary)
                        .lineHeight(1.5)
                )
            }
        }
    }
}