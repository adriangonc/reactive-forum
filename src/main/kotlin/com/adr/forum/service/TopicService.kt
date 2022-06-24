package com.adr.forum.service

import com.adr.forum.dto.NewTopicDto
import com.adr.forum.model.Answeres
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


    fun listTopics(): Flux<Topic> {
        return topics.toFlux()
    }

    fun findTopicById(id: Long): Mono<Topic> {
        return topics.stream().filter { t ->
            t.id == id
        }.findFirst().get().toMono()
    }

    fun createTopic(topicDto: NewTopicDto) {

        topics = topics.plus(
            Topic(
                id = topics.size.toLong() + 1,
                title = topicDto.title,
                mensage = topicDto.message,
                author = userService.findById(topicDto.idAuthor),
                course = courseService.findByIdCourse(topicDto.idCourse),
                status = StatusTopic.NOT_ANSWERED,
                answeres = ArrayList()
            )
        )


    }

}