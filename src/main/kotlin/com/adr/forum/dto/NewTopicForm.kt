package com.adr.forum.dto

data class NewTopicForm(
    val title: String,
    val message: String,
    val idCourse: Long,
    val idAuthor: Long
)
