package com.adr.forum.repository

import com.adr.forum.model.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository: JpaRepository<Course, Long> {
    abstract fun findByName(courseName: String): List<Course>
}