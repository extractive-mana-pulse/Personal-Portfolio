package com.example.webcv.pages.contact

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import org.jetbrains.compose.web.css.px

@Composable
internal fun ContactInfo() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .gap(24.px)
    ) {
        ContactItem(
            icon = "/icons/email.svg",
            label = "EMAIL",
            value = "mukhammadaminsalokhiddinov@gmail.com",
            url = "mailto:mukhammadaminsalokhiddinov@gmail.com"
        )

        ContactItem(
            icon = "/icons/location.svg",
            label = "LOCATION",
            value = "Tashkent, Uzbekistan",
            url = "https://maps.app.goo.gl/D53AupAfQudLmSum9"
        )
    }
}