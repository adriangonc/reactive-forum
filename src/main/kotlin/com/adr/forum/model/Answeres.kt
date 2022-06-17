package com.adr.forum.model

import java.time.LocalDateTime

data class Answeres (
    val id: Long? = null,
    val mensagem: String,
    val creationDate: LocalDateTime = LocalDateTime.now(),
    val author: User,
    val topic: Topic,
    val solution: Boolean
)
