package com.foresty.domain.jpa.repository

import com.foresty.domain.jpa.model.user.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserJpaRepository: JpaRepository<UserEntity, Long> {
    fun findByName(name: String)
}