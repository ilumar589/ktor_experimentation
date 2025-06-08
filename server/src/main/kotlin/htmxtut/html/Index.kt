package com.playground.htmxtut.html

import com.playground.htmxtut.repository.UserRepository
import kotlinx.html.BODY
import kotlinx.html.FlowContent
import kotlinx.html.HTML
import kotlinx.html.body
import kotlinx.html.h5
import kotlinx.html.head
import kotlinx.html.script

fun HTML.renderIndex(userRepository: UserRepository) {
    head {
        script { src = "/web.js" } // created from the web module, contains htmx downloaded through npm
    }
    body {
        insertHeader()
        insertUserForm()
        insertUserTable(users = userRepository.findAll())

        insertErrorHandlingScripts()
    }
}

// interface for all classes representing html tags
private fun FlowContent.insertHeader() {
    h5 { + "Users List" }
}

private fun BODY.insertErrorHandlingScripts() {
    //TODO in web component because in the tutorial he is writing a dom manipulation script in a string
}