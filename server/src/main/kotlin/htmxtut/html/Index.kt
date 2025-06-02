package com.playground.htmxtut.html

import com.playground.htmxtut.repository.UserRepository
import kotlinx.html.FlowContent
import kotlinx.html.HTML
import kotlinx.html.body
import kotlinx.html.h5

fun HTML.renderIndex(userRepository: UserRepository) {
    body {
        insertHeader()
        insertUserForm()
        insertUserTable(users = userRepository.findAll())
    }
}

// interface for all classes representing html tags
private fun FlowContent.insertHeader() {
    h5 { + "Users List" }
}