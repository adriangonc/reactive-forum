package com.adr.forum.model

import javax.persistence.*

@Entity
@Table(name="TB_COURSE")
data class Course (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val category: String
) /*{
    constructor() : this(1L, "", "")
}*/
