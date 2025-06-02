package com.playground

import com.playground.htmxtut.repository.UserRepository
import com.playground.htmxtut.routing.registerUserRoutes
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    val userRepository = UserRepository()

    registerUserRoutes(userRepository)
}

// moved exampled outside of module function just for cleanup. Put back if you want to test something
//    configureAdministration()
//    configureDatabases()
//    configureSerialization()
//    configureTemplating()
//    configureSecurity()
//    configureHTTP()
//    configureRouting()

