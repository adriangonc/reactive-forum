package com.adr.forum.controller

import com.adr.forum.model.Course
import com.adr.forum.model.Topic
import com.adr.forum.model.User

class Util {
    fun createTopic() = Topic(
        id = 1L,
        title = "Duvida list kotlin",
        message = "Array list kotlin",
        course = Course(
            id = 1,
            name = "Kotlin + spring",
            category = "Programacao web"
        ),
        author = User(
            id = 1L,
            name = "Adriano",
            email = "adriangonc@yahoo.com.br",
            password = "teste123"
        )
    )
}