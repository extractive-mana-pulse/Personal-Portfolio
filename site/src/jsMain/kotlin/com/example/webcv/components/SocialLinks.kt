package com.example.webcv.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.margin
import org.jetbrains.compose.web.css.px

@Composable
internal fun SocialLinks() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .margin(top = 32.px),
        horizontalArrangement = Arrangement.spacedBy(12.px)
    ) {
        SocialIcon(
            icon = "icons/medium.svg",
            url = "https://medium.com/@invoker1441",
            borderRadius = 8.px
        )

        SocialIcon(
            icon = "/github.svg",
            url = "https://github.com/extractive-mana-pulse",
            borderRadius = 0.px
        )

        SocialIcon(
            icon = "icons/linkedin.svg",
            url = "https://www.linkedin.com/in/mukhammadamin-s/",
            borderRadius = 4.px
        )
    }
}