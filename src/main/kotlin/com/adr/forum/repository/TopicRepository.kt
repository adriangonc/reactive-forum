package com.adr.forum.repository

import com.adr.forum.model.Topic
import org.springframework.data.jpa.repository.JpaRepository

interface TopicRepository: JpaRepository<Topic, Long> {

    fun findByCourseName(courseName: String): List<Topic> //findBy 'Jpa entende como select' //Course 'Jpa entende como classe Course' // Name 'Jpa entende como atributo name'

}