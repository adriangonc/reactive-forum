package com.adr.forum.service

import com.adr.forum.model.Course
import com.adr.forum.repository.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(private val repository: CourseRepository) {

    fun findByIdCourse(id: Long): Course {
        return repository.getOne(id)
    }

}
