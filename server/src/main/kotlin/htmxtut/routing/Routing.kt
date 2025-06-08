package com.playground.htmxtut.routing

import com.playground.htmxtut.html.insertUserRowCells
import com.playground.htmxtut.html.renderIndex
import com.playground.htmxtut.repository.UserRepository
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.request.*
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.*
import kotlinx.html.stream.createHTML
import kotlinx.html.tr

fun Application.registerUserRoutes(userRepository: UserRepository) {
    routing {
        staticResources("/", "/web")

        get("/") {
            call.respondHtml {
                renderIndex(userRepository)
            }
        }

        route("/users") {
            post {

                val formParameters = call.receiveParameters()
                val firstName = formParameters["first-name"]
                val lastName = formParameters["last-name"]
                val isActive = formParameters["enabled-radio"]?.toBoolean() ?: false

                if (firstName.isNullOrBlank() || lastName.isNullOrBlank()) {
                    return@post call.respond(HttpStatusCode.BadRequest)
                }

                val createUser = userRepository.create(firstName, lastName, isActive)

                val createdUserHtml = createHTML().tr { insertUserRowCells(createUser) }

                call.respondText(createdUserHtml, contentType = ContentType.Text.Html)
            }

            delete("/{id}") {
                val id = call.parameters["id"]!!

                userRepository.delete(id)

                call.respond(HttpStatusCode.OK)
            }
        }
    }
}


