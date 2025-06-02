package com.playground.htmxtut.routing

import com.playground.htmxtut.html.renderIndex
import com.playground.htmxtut.repository.UserRepository
import io.ktor.server.application.Application
import io.ktor.server.html.respondHtml
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

fun Application.registerUserRoutes(userRepository: UserRepository) {

    routing {
        get("/") {
            call.respondHtml {
                renderIndex(userRepository)
            }
        }
    }
}