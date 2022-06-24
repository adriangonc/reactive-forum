package com.adr.forum.service

import com.adr.forum.model.Course
import org.springframework.stereotype.Service
import java.util.*

@Service
class CourseService(var courses: List<Course> ) {

    init {
        val course = Course(
            id = 1,
            name = "Kotlin with Spring",
            category = "Programing"
        )
        courses = Arrays.asList(course)
    }

    fun findByIdCourse(id: Long): Course {
        return courses.stream().filter({
            c -> c.id == id
        }).findFirst().get()
    }

}
