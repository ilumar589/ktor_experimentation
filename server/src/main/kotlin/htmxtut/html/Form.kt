package com.playground.htmxtut.html

import kotlinx.html.FlowContent
import kotlinx.html.InputType
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.form
import kotlinx.html.id
import kotlinx.html.input
import kotlinx.html.label

fun FlowContent.insertUserForm() {
    div {
        form {
            attributes["hx-post"] = "/users"
            attributes["hx-target"] = "#users-table"
            attributes["hx-swap"] = "beforeend"

            div {
                div {
                    label {
                        htmlFor = "first-name"
                       +"First Name"
                    }
                    input {
                        type = InputType.text
                        name = "first-name"
                        id = "first-name"
                        placeholder = "First name"
                    }
                }

                div {
                    label {
                        htmlFor = "last-name"
                        +"Last Name"
                    }
                    input {
                        type = InputType.text
                        name = "last-name"
                        id = "last-name"
                        placeholder = "Last name"
                    }
                }

                div {
                    label {
                        + "Account enabled"
                    }
                    div {
                        div {
                            input {
                                type = InputType.radio
                                name = "enabled-radio"
                                id = "radio-button-1"
                                value = "true"
                            }
                            label {
                                htmlFor = "radio-button-1"
                                +"Yes"
                            }
                        }

                        div {
                            input {
                                type = InputType.radio
                                name = "enabled-radio"
                                id = "radio-button-2"
                                value = "false"
                            }
                            label {
                                htmlFor = "radio-button-2"
                                +"No"
                            }
                        }
                    }
                }

                div {
                    button {
                         + "Add user"
                    }
                }
            }
        }
    }
}