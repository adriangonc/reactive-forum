package com.adr.forum.controller

import com.adr.forum.dto.NewTopicForm
import com.adr.forum.dto.TopicView
import com.adr.forum.dto.UpdateTopicForm
import com.adr.forum.service.TopicService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
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
    fun createTopic(
        @RequestBody @Valid topic: NewTopicForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicView> {
        val topicView = service.createTopic(topic)
        val uri = uriBuilder.path("/topics/${topicView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicView)
    }

    @PutMapping
    fun updateTopic(@RequestBody @Valid topic: UpdateTopicForm): ResponseEntity<TopicView> {
        var topicView = service.updateTopic(topic)
        return ResponseEntity.ok(topicView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTopic(@PathVariable id: Long) {
        service.deleteTopic(id)
    }

    @PostMapping("/create-topics-for-test/{qtd}")
    fun createTopicsForTest(@PathVariable qtd: Long) {
        service.createTopicsForTest(qtd)
    }

}