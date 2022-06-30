package com.adr.forum.model

import java.time.LocalDateTime

class Topic (
    var id: Long? = null,
    var title: String,
    var message: String,
    val creationDate: LocalDateTime = LocalDateTime.now(),
    val course: Course,
    val author: User,
    val status: StatusTopic = StatusTopic.NOT_ANSWERED,
    val answeres: List<Answeres> = ArrayList()
)