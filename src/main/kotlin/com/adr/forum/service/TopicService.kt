package com.adr.forum.service

import com.adr.forum.dto.NewTopicForm
import com.adr.forum.dto.TopicView
import com.adr.forum.mapper.TopicFormMapper
import com.adr.forum.mapper.TopicViewMapper
import com.adr.forum.model.StatusTopic
import com.adr.forum.model.Topic
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toFlux
import reactor.kotlin.core.publisher.toMono
import kotlin.collections.ArrayList

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper
) {

    fun listTopics(): Flux<TopicView> {
        return topics.stream().map { t ->
            t.id?.let {
                topicViewMapper.map(t)
            }
        }.toFlux()
    }

    fun findTopicById(id: Long): Mono<TopicView>? {
        val topic = topics.stream().filter { t ->
            t.id == id
        }.findFirst().get()
        return topic.id?.let {
            topicViewMapper.map(topic).toMono()
        }
    }

    fun createTopic(form: NewTopicForm) {
        val topic = topicFormMapper.map(form)
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)
    }

}