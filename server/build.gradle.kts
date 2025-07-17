import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktor)
    alias(libs.plugins.kotlin.plugin.serialization)
}

kotlin {
    jvmToolchain(24)
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_24)
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(24))
    }
}

application {
    mainClass = "io.ktor.server.netty.EngineMain"

    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=true")
}

tasks.withType<ProcessResources> {
    val wasmOutput = file("../web/build/dist/wasmJs/productionExecutable")
    if (wasmOutput.exists()) {
        inputs.dir(wasmOutput)
    }

    from("../web/build/dist/wasmJs/productionExecutable") {
        into("web")
        include("**/*")
    }
    duplicatesStrategy = DuplicatesStrategy.WARN
}

dependencies {
    implementation(libs.ktor.server.task.scheduling.core)
    implementation(libs.ktor.server.task.scheduling.redis)
    implementation(libs.ktor.server.task.scheduling.mongodb)
    implementation(libs.ktor.server.task.scheduling.jdbc)
    implementation(libs.ktor.server.kafka)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.postgresql)
    implementation(libs.h2)
    implementation(libs.exposed.core)
    implementation(libs.exposed.jdbc)
    implementation(libs.ktor.server.html.builder)
    implementation(libs.kotlinx.html)
    implementation(libs.kotlin.css)
    implementation(libs.ktor.server.sse)
    implementation(libs.ktor.server.host.common)
    implementation(libs.ktor.server.status.pages)
    implementation(libs.ktor.server.sessions)
    implementation(libs.ktor.server.partial.content)
    implementation(libs.ktor.server.forwarded.header)
    implementation(libs.ktor.server.default.headers)
    implementation(libs.ktor.server.compression)
    implementation(libs.ktor.server.caching.headers)
    implementation(libs.ktor.server.netty)
    implementation(libs.logback.classic)
    implementation(libs.ktor.server.config.yaml)
    testImplementation(libs.ktor.server.test.host)
    testImplementation(libs.kotlin.test.junit)
}
