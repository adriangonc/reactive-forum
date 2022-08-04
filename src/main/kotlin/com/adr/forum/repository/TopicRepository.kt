package com.adr.forum.repository

import com.adr.forum.dto.TopicByCategoryDto
import com.adr.forum.model.Topic
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicRepository: JpaRepository<Topic, Long> {

    fun findByCourseName(courseName: String): List<Topic> //findBy 'Jpa entende como select' //Course 'Jpa entende como classe Course' // Name 'Jpa entende como atributo name'

    @Query("SELECT new com.adr.forum.dto.TopicByCategoryDto(course.category, count(t)) FROM Topic t JOIN t.course course GROUP BY course.category")
    fun reportTopics(): List<TopicByCategoryDto>

}