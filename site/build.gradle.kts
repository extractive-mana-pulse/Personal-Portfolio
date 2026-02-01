import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.link

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kobweb.application)
    alias(libs.plugins.kobwebx.markdown)
}

group = "com.example.webcv"
version = "1.0-SNAPSHOT"

kobweb {
    app {
        index {
            description.set("Powered by Kobweb")

            head.add {
                link(rel = "stylesheet", href = "/fonts/faceInter.css")
                link(rel = "stylesheet", href = "/fonts/DMSerif.css")
                link(rel = "preconnect", href = "https://fonts.googleapis.com")
                link(rel = "preconnect", href = "https://fonts.gstatic.com") {
                    attributes["crossorigin"] = ""
                }
                link(
                    href = "https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;700&family=Playfair+Display:wght@700&display=swap",
                    rel = "stylesheet"
                )
            }
        }
    }
}

kotlin {
    configAsKobwebApplication("webcv")

    sourceSets {
        jsMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.html.core)
            implementation(libs.kobweb.core)
            implementation(libs.kobweb.silk)
            implementation(libs.silk.icons.fa)
            implementation(libs.kobwebx.markdown)
            implementation(project(":worker"))
        }
    }
}