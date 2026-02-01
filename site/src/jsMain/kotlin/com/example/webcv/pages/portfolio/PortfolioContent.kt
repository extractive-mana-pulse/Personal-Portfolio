package com.example.webcv.pages.portfolio

import androidx.compose.runtime.*
import com.example.webcv.pages.portfolio.components.PortfolioCard
import com.example.webcv.pages.portfolio.components.PortfolioFilterTab
import com.example.webcv.pages.portfolio.model.portfolioItems
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.px

@Composable
internal fun PortfolioContent() {

    var selectedCategory by remember { mutableStateOf("All") }
    val filteredItems = if (selectedCategory == "All") {
        portfolioItems
    } else {
        portfolioItems.filter { it.category == selectedCategory }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.px)
            .overflow(Overflow.Auto)
            .gap(32.px)
    ) {
        Row(
            modifier = Modifier.gap(16.px),
            verticalAlignment = Alignment.CenterVertically
        ) {
            listOf("All", "Android", "iOS").forEach { category ->
                PortfolioFilterTab(
                    text = category,
                    isActive = selectedCategory == category,
                    onClick = { selectedCategory = category }
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .gap(24.px)
                .flexWrap(FlexWrap.Wrap)
        ) {
            filteredItems.forEach { item ->
                PortfolioCard(
                    item,
                    url = item.url,
                )
            }
        }
    }
}