package com.adr.forum.service

import com.adr.forum.model.User
import com.adr.forum.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val repository: UserRepository) {

    fun findById(id: Long): User {
        return repository.getOne(id)
    }

}
