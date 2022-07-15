package com.adr.forum.dto

import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Schema(description = "Model for new topic creation.")
data class NewTopicForm(
    @field:NotEmpty @field:Size(min = 10, max = 200) val title: String,
    @field:NotEmpty @field:Size(min = 10, max = 4000) val message: String,
    @field:NotNull val idCourse: Long,
    @field:NotNull var idAuthor: Long
)
