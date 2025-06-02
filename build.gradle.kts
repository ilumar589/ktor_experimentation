
plugins {
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.ktor) apply false
    alias(libs.plugins.kotlin.plugin.serialization) apply false
}

subprojects {
    repositories {
        mavenCentral()
        maven { url = uri("https://packages.confluent.io/maven/") }
        maven { url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-js-wrappers") }
    }

    group = "com.playground"
    version = "0.0.1"
}
