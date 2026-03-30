package com.example.webcv.pages.portfolio.model

data class PortfolioItem(
    val title: String,
    val platforms: List<String>,
    val imageUrl: String,
    val categories: List<String>,
    val url: String,
    val description: String = ""
)