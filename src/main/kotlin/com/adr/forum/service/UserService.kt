package com.adr.forum.service

import com.adr.forum.model.User
import com.adr.forum.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service


@Service
class UserService(private val repository: UserRepository) : UserDetailsService {

    fun findById(id: Long): User {
        return repository.getOne(id)
    }

    override fun loadUserByUsername(username: String?): UserDetails? {
        val user = repository.findByEmail(username) ?: throw RuntimeException()
        return UserDetail(user)
    }

}
