package com.adr.forum.model

import org.springframework.security.core.GrantedAuthority
import javax.persistence.*

@Entity
@Table(name="TB_ROLE")
data class Role(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,
    private val name: String
) :GrantedAuthority {
    override fun getAuthority() = name
}