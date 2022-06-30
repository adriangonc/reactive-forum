package com.adr.forum.controller

import com.adr.forum.dto.NewTopicForm
import com.adr.forum.dto.TopicView
import com.adr.forum.dto.UpdateTopicForm
import com.adr.forum.service.TopicService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import javax.validation.Valid

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    fun listTopics(): Flux<TopicView> {
        return service.listTopics()
    }

    @GetMapping("/{id}")
    fun findTopicById(@PathVariable id: Long): Mono<TopicView>? {
        return service.findTopicViewById(id)
    }

    @PostMapping
    fun createTopic(@RequestBody @Valid topic: NewTopicForm): NewTopicForm {
        service.createTopic(topic)
        return topic
    }

    @PutMapping
    fun updateTopic(@RequestBody @Valid topic: UpdateTopicForm): UpdateTopicForm {
        service.updateTopic(topic)
        return topic
    }

    @DeleteMapping("/{id}")
    fun deleteTopic(@PathVariable id: Long){
        service.deleteTopic(id)
    }

}