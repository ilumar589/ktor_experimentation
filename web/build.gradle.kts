
plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    @OptIn(org.jetbrains.kotlin.gradle.ExperimentalWasmDsl::class)
    wasmJs {
        browser {
            commonWebpackConfig {
                outputFileName = "web.js"
            }
        }
        binaries.executable()
    }

    sourceSets {
        val wasmJsMain by getting {
            dependencies {
                implementation(npm("htmx.org", "2.0.4"))
                implementation(npm("tailwindcss", "4.1.8"))
                implementation(libs.kotlinx.browser)
            }
        }
    }
}
