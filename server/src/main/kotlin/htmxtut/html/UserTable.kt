package com.playground.htmxtut.html

import com.playground.htmxtut.repository.User
import kotlinx.html.FlowContent
import kotlinx.html.TR
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.id
import kotlinx.html.img
import kotlinx.html.p
import kotlinx.html.span
import kotlinx.html.table
import kotlinx.html.tbody
import kotlinx.html.td
import kotlinx.html.th
import kotlinx.html.thead
import kotlinx.html.tr
import java.time.format.DateTimeFormatter

fun FlowContent.insertUserTable(users: List<User>) {
    div {
       table {
           thead {
                tr {
                    th { +"User" }
                    th { +"Status" }
                    th { +"Created At" }
                    th {  }
                }
           }

           tbody {
               id = "users-table"

               users.forEach { user ->
                   tr {
                       insertUserRowCells(user)
                   }
               }
           }
       }
    }
}

fun TR.insertUserRowCells(user: User) {
    td {
        div {
            img {
                src = "/img/user_placeholder.png"
            }
        }
    }

    td {
        div {
            p {
                + "${user.firstName} ${user.lastName}"
            }
        }
    }

    td {
        div {
            div {
                val enabledLabel = if (user.enabled) "Enabled" else "Disabled"
                val labelColor = if (user.enabled) "green" else "red"

                span {
                    + enabledLabel
                }
            }
        }
    }

    td {
        p {
            + user.createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        }
    }

    td {
        button {
            attributes["hx-delete"] = "/users/${user.id}"
            attributes["hx-swap"] = "outerHtml"
            attributes["hx-target"] = "closest tr"

            + "Delete"
        }
    }
}