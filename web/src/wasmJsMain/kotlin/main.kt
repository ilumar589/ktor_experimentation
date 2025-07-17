package com.playground

import kotlin.js.*
import kotlinx.browser.*
import org.w3c.dom.events.Event

@JsModule("htmx.org")
external object htmx

fun main() {
    document.body?.apply {
        var rowCount = 1
        // Update the total count of items
        addEventListener("htmx:beforeSwap") {
            document.getElementById("total-count")?.innerHTML = "Total: ${(++rowCount) * 10}"
        }
        // Scroll to the bottom of the page after adding content
        addEventListener("htmx:afterSwap") {
            window.scrollTo(0.0, scrollHeight.toDouble())
        }

        addEventListener("htmx:responseError") {
            window.alert("An error occurred! HTTP status: ${it}") // don't know how I can get the status out of this
        }

        addEventListener("htmx:sendError") {
            window.alert("Server unavailable!")
        }
    }
}
