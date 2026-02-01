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
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.graphics.ImageFetchPriority
import com.varabyte.kobweb.silk.components.text.SpanText
import kotlinx.browser.window
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba

@Composable
internal fun PortfolioCard(item: PortfolioItem, url: String) {
    var isHovered by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .styleModifier {
                property("width", "calc((100% - 48px) / 2)")
            }
            .minWidth(280.px)
            .gap(16.px)
    ) {
        // Image Container
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.px) // Fixed height instead of size
                .borderRadius(24.px)
                .backgroundColor(PortfolioColors.cardBg)
                .overflow(Overflow.Hidden)
                .position(Position.Relative)
                .cursor(Cursor.Pointer)
                .styleModifier {
                    property("transition", "transform 0.3s ease, box-shadow 0.3s ease")
                    if (isHovered) {
                        property("transform", "translateY(-4px)")
                        property("box-shadow", "0 12px 24px rgba(0, 0, 0, 0.15)")
                    }
                }
                .onMouseEnter { isHovered = true }
                .onMouseLeave { isHovered = false }
                .onClick {
                    window.open(
                        url = url,
                        target = "_blank",
                    )
                },
            contentAlignment = Alignment.Center
        ) {
            // Image
            Image(
                src = item.imageUrl,
                modifier = Modifier
                    .fillMaxSize()
                    .objectFit(ObjectFit.Fill)
                    .styleModifier {
                        property("transition", "transform 0.3s ease")
                        if (isHovered) {
                            property("transform", "scale(1.05)")
                        }
                    },
                fetchPriority = ImageFetchPriority.High
            )

            if (isHovered) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .backgroundColor(rgba(0, 0, 0, 0.5))
                        .styleModifier {
                            property("transition", "opacity 0.3s ease")
                            property("animation", "fadeIn 0.3s ease")
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(64.px)
                            .borderRadius(24.px)
                            .backgroundColor(rgba(255, 255, 255, 0.95))
                            .styleModifier {
                                property("transition", "transform 0.2s ease")
                                property("animation", "scaleIn 0.3s ease")
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            src = "/icons/preview.svg",
                            modifier = Modifier
                                .size(28.px)
                                .styleModifier {
                                    property("filter", "brightness(0.3)")
                                }
                        )
                    }
                }
            }
        }

        Column(
            modifier = Modifier
                .gap(4.px)
                .padding(leftRight = 4.px)
        ) {
            SpanText(
                text = item.title,
                modifier = Modifier
                    .fontSize(20.px)
                    .fontWeight(FontWeight.SemiBold)
                    .color(PortfolioColors.textPrimary)
                    .lineHeight(1.4)
            )
            SpanText(
                text = item.platform,
                modifier = Modifier
                    .fontSize(14.px)
                    .fontWeight(FontWeight.Normal)
                    .color(PortfolioColors.textSecondary)
                    .opacity(0.8)
            )
        }
    }
}