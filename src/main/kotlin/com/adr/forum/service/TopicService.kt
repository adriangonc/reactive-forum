package com.adr.forum.service

import com.adr.forum.dto.NewTopicForm
import com.adr.forum.dto.TopicView
import com.adr.forum.dto.UpdateTopicForm
import com.adr.forum.mapper.TopicFormMapper
import com.adr.forum.mapper.TopicViewMapper
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

    fun findTopicViewById(id: Long): Mono<TopicView>? {
        val topic = findTopicById(id)
        return topic.id?.let {
            topicViewMapper.map(topic).toMono()
        }
    }

    private fun findTopicById(id: Long) = topics.stream().filter { t ->
        t.id == id
    }.findFirst().get()

    fun createTopic(form: NewTopicForm) {
        val topic = topicFormMapper.map(form)
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)
    }

    fun updateTopic(topic: UpdateTopicForm) {
        var topicToUpdate = findTopicById(topic.id)

        try {
            topics = topics.minus(topicToUpdate)
            topicToUpdate.message = topic.message
            topicToUpdate.title = topic.title
            topics = topics.plus(topicToUpdate)
        } catch (e: Exception) {
            println(e)
        }
    }

    fun deleteTopic(id: Long) {
        var topicToDelete = findTopicById(id)
        topics = topics.minus(topicToDelete)
    }

}