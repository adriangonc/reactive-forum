package com.adr.forum.controller

import com.adr.forum.dto.NewTopicForm
import com.adr.forum.dto.TopicView
import com.adr.forum.dto.UpdateTopicForm
import com.adr.forum.service.TopicService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import javax.validation.Valid


@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    fun listTopics(@RequestParam(required = false) courseName: String?): Flux<TopicView> {
        return service.listTopics(courseName)
    }

    @GetMapping("/{id}")
    fun findTopicById(@PathVariable id: Long): Mono<TopicView>? {
        return service.findTopicViewById(id)
    }

    @PostMapping
    @Transactional
    fun createTopic(
        @RequestBody @Valid topic: NewTopicForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicView> {
        val topicView = service.createTopic(topic)
        val uri = uriBuilder.path("/topics/${topicView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicView)
    }

    @PutMapping
    @Transactional
    fun updateTopic(@RequestBody @Valid topic: UpdateTopicForm): ResponseEntity<TopicView> {
        var topicView = service.updateTopic(topic)
        return ResponseEntity.ok(topicView)
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTopic(@PathVariable id: Long) {
        service.deleteTopic(id)
    }

    @PostMapping("/create-topics-for-test/{qtd}")
    @Transactional
    fun createTopicsForTest(@PathVariable qtd: Long) {
        service.createTopicsForTest(qtd)
    }

}