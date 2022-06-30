package com.adr.forum.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

class UpdateTopicForm (
    @field:NotNull
    val id: Long,

    @field:NotEmpty
    @Size(min =10, max = 200)

    @field:NotEmpty
    @Size(min =10, max = 200)
    val title: String,

    @field:NotEmpty
    @Size(min =10, max = 4000)
    val message: String
)
