package com.adr.forum.service

import com.adr.forum.dto.NewTopicForm
import com.adr.forum.dto.TopicView
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
    private var courseService: CourseService,
    private var userService: UserService
) {


    fun listTopics(): Flux<TopicView> {
        return topics.stream().map { t ->
            t.id?.let {
                TopicView(
                    id = it,
                    title = t.title,
                    message = t.message,
                    creationDate = t.creationDate,
                    status = t.status
                )
            }
        }.toFlux()
    }

    fun findTopicById(id: Long): Mono<TopicView>? {
        val topic = topics.stream().filter { t ->
            t.id == id
        }.findFirst().get()
        return topic.id?.let {
            TopicView(
                id = it,
                title = topic.title,
                message = topic.message,
                creationDate = topic.creationDate,
                status = topic.status
            ).toMono()
        }
    }

    fun createTopic(topicDto: NewTopicForm) {

        topics = topics.plus(
            Topic(
                id = topics.size.toLong() + 1,
                title = topicDto.title,
                message = topicDto.message,
                author = userService.findById(topicDto.idAuthor),
                course = courseService.findByIdCourse(topicDto.idCourse),
                status = StatusTopic.NOT_ANSWERED,
                answeres = ArrayList()
            )
        )


    }

}