package com.example.webcv.pages.resume

import androidx.compose.runtime.Composable
import com.example.webcv.pages.resume.components.ResumeSection
import com.example.webcv.pages.resume.model.ResumeItem
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.css.px

@Composable
fun ResumeContent() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.px)
            .overflow(Overflow.Auto)
            .styleModifier {
                property("overflow-y", "auto")
                property("overflow-x", "hidden")
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 64.px, bottom = 64.px, leftRight = 24.px)
                .gap(64.px),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ResumeSection(
                title = "Education",
                icon = "/icons/education.svg",
                items = listOf(
                    ResumeItem(
                        title = "Turin Polytechnic University in Tashkent | Bachelor of Science",
                        period = "2020 — 2024",
                        description = "Software Engineer"
                    ),
                    ResumeItem(
                        title = "Turin Polytechnic University in Tashkent | Master of Science",
                        period = "2024 — Present",
                        description = "Telecommunication engineering and Computer Science"
                    )
                )
            )
            ResumeSection(
                title = "Experience",
                icon = "/icons/education.svg",
                items = listOf(
                    ResumeItem(
                        title = "TTPU (Turin Polytechnic University in Tashkent)",
                        period = "2025 — 2026",
                        description = "Mentor Mobile Software Development to Software Engineering students at Turin Polytechnic University in Tashkent. Focus on practical, industry-aligned mobile engineering skills and real-world development practices. Collaborated with PL Coding to provide students partially free access to paid professional materials, enhancing hands-on learning and industry readiness."
                    ),
                    ResumeItem(
                        title = "U-Development Team",
                        period = "2023 — 2024",
                        description = "Advanced from Intern to Code Reviewer on the production-grade, multi-module, cross-platform Green Light ELD app (live on App Store and Google Play). Conduct code reviews focused on performance optimization, memory efficiency, and architectural best practices, contributing to improved app stability and maintainability."
                    ),
                    ResumeItem(
                        title = "LongHorn Logistics Company",
                        period = "a month",
                        description = "Initially hired as a Native Android Developer, later contributed to internal process automation and software analysis, helping reduce human error and improve operational efficiency. Currently dedicated full-time to Android development, focusing on performance, feature implementation, and code quality."
                    )
                )
            )
        }
    }
}