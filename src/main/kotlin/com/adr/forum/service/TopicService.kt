package com.adr.forum.service

import com.adr.forum.model.Course
import com.adr.forum.model.Topic
import com.adr.forum.model.User
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toFlux
import reactor.kotlin.core.publisher.toMono
import java.util.*
import kotlin.collections.ArrayList

@Service
class TopicService(private var topics: List<Topic> = ArrayList()) {


    fun listTopics(): Flux<Topic> {
        return topics.toFlux()
    }

    fun findTopicById(id: Long): Mono<Topic> {
        return topics.stream().filter { t ->
            t.id == id
        }.findFirst().get().toMono()
    }

    fun createTopic(topic: Topic) {
        topics.plus(topic)
    }

}