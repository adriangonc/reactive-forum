package com.adr.forum.service

import com.adr.forum.model.Course
import com.adr.forum.repository.CourseRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.kotlin.core.publisher.toFlux

@Service
class CourseService(private val repository: CourseRepository) {

    fun findByIdCourse(id: Long): Course {
        return repository.getOne(id)
    }

    fun findCourse(courseName: String?): Flux<Course> {
        if(!courseName.isNullOrEmpty()){
            return repository.findByName(courseName).toFlux()
        }
        return repository.findAll().toFlux()
    }

    fun createCourse(course: Course): Course {
        repository.saveAndFlush(course)
        return course
    }

}
