package com.adr.forum.mapper

import com.adr.forum.dto.NewTopicForm
import com.adr.forum.model.StatusTopic
import com.adr.forum.model.Topic
import com.adr.forum.service.CourseService
import com.adr.forum.service.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
    private var courseService: CourseService,
    private var userService: UserService
): Mapper<NewTopicForm, Topic> {
    override fun map(t: NewTopicForm): Topic {

        return Topic(
            title = t.title,
            message = t.message,
            author = userService.findById(t.idAuthor),
            course = courseService.findByIdCourse(t.idCourse),
            status = StatusTopic.NOT_ANSWERED,
            answers = ArrayList()
        )
    }

}
