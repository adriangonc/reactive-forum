package com.adr.forum.controller

import com.adr.forum.dto.NewTopicForm
import com.adr.forum.model.Course
import com.adr.forum.service.CourseService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import javax.validation.Valid

@RestController
@RequestMapping("/course")
class CourseController(private val courseService: CourseService) {

    @GetMapping
    @Cacheable("course-list-cache")
    fun listCourses(@RequestParam(required = false) courseName: String?): Flux<Course> {
        return courseService.findCourse(courseName)
    }

    @PostMapping
    @Transactional
    @CacheEvict(*["course-list-cache", "cacheTest"], allEntries = true)
    fun createCourse(@RequestBody @Valid course: Course): Course {
        return courseService.createCourse(course)
    }

}