package com.adr.forum.model

import java.time.LocalDateTime

class Topic (
    val id: Long? = null,
    val title: String,
    val mensage: String,
    val creationDate: LocalDateTime = LocalDateTime.now(),
    val course: Course,
    val author: User,
    val status: StatusTopic = StatusTopic.NOT_ANSWERED,
    val answeres: List<Answeres> = ArrayList()
)