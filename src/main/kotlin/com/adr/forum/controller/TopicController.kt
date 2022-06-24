package com.adr.forum.controller

import com.adr.forum.dto.NewTopicDto
import com.adr.forum.model.Course
import com.adr.forum.model.Topic
import com.adr.forum.model.User
import com.adr.forum.service.TopicService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toFlux
import java.util.Arrays

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    fun listTopics(): Flux<Topic> {
        return service.listTopics()
    }

    @GetMapping("/{id}")
    fun findTopicById(@PathVariable id: Long): Mono<Topic> {
        return service.findTopicById(id)
    }

    @PostMapping
    fun createTopic(@RequestBody topic: NewTopicDto): NewTopicDto {
        service.createTopic(topic)
        return topic
    }

}