package com.playground.htmxtut.repository

import java.time.LocalDateTime
import java.util.*

data class User(val id: String = UUID.randomUUID().toString(),
                val firstName: String,
                val lastName: String,
                val enabled: Boolean,
                val createdAt: LocalDateTime = LocalDateTime.now())

class UserRepository {

    // just for demo purposes, doesn't need to be thread safe!
    private val users = mutableListOf(
        User(firstName = "John", lastName = "Doe", enabled = true),
        User(firstName = "Jane", lastName = "Doe", enabled = false),
        User(firstName = "Billy", lastName = "Bob", enabled = true),
        User(firstName = "Bob", lastName = "Billy", enabled = false),
        User(firstName = "Jane", lastName = "Jones", enabled = true),
    )

    fun create(firstName: String, lastName: String, enabled: Boolean): User =
        User(firstName = firstName, lastName = lastName, enabled = enabled)
            .also { users.add(it) }

    fun findAll(): List<User> = users

    fun delete(id: String) = users.removeIf { it.id == id }
}