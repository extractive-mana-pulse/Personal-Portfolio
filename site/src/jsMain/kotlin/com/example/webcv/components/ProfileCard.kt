package com.example.webcv.components

import androidx.compose.runtime.Composable
import com.example.webcv.pages.contact.ContactInfo
import com.example.webcv.ui.PortfolioColors
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.graphics.ImageFetchPriority
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.*

@Composable
internal fun ProfileCard() {
    Column(
        modifier = Modifier
            .width(340.px)
            .background(PortfolioColors.cardBg)
            .border(
                width = 1.px,
                style = LineStyle.Solid,
                color = PortfolioColors.borderLight
            )
            .borderRadius(24.px)
            .padding(40.px),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(200.px)
                .borderRadius(50.percent)
                .overflow(Overflow.Hidden)
                .backgroundColor(PortfolioColors.border)
        ) {
            Image(
                src = "/icons/resume_picture.jpg",
                modifier = Modifier.fillMaxSize().objectFit(ObjectFit.Cover),
                fetchPriority = ImageFetchPriority.High
            )
        }
        SpanText(
            text = "Mukhammadamin Salokhiddinov",
            modifier = Modifier
                .margin(top = 32.px)
                .fontSize(28.px)
                .fontWeight(400)
                .lineHeight(1.7)
                .letterSpacing(0.2.px)
                .fontFamily("DM Serif Display", "sans-serif")
                .color(PortfolioColors.textPrimary)
                .textAlign(TextAlign.Center)
        )
        SpanText(
            text = "Software Engineer",
            modifier = Modifier
                .margin(top = 8.px)
                .fontSize(16.px)
                .color(Color.white)
                .fontFamily("Inter", "sans-serif")
                .backgroundColor(rgb(38, 38, 38))
                .borderRadius(8.px)
                .padding(
                    right = 16.px, left = 16.px, top = 4.px, bottom = 4.px
                )
        )
        Box(
            modifier = Modifier
                .width(100.percent)
                .height(1.px)
                .background(PortfolioColors.border)
                .margin(topBottom = 32.px)
        )
        ContactInfo()
        SocialLinks()
    }
}