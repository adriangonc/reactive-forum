package com.adr.forum.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name="TB_ANSWERES")
data class Answeres (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val mensagem: String,
    val creationDate: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val author: User,
    @ManyToOne
    val topic: Topic,
    val solution: Boolean
)
