package com.adr.forum.repository

import com.adr.forum.model.Topic
import org.springframework.data.jpa.repository.JpaRepository

interface TopicRepository: JpaRepository<Topic, Long> {

}