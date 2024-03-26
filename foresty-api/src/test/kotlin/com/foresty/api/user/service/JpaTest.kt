package com.foresty.api.user.service

import com.foresty.domain.exposed.model.user.domain.User
import com.foresty.domain.jpa.model.user.UserEntity
import com.foresty.domain.jpa.repository.UserJpaRepository
import jakarta.persistence.PersistenceContext
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.transaction.annotation.Transactional


@DataJpaTest(showSql = true)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class JpaTest(
    @Autowired val userJpaRepository: UserJpaRepository
) {

    val log: Logger = LoggerFactory.getLogger(JpaTest::class.java)

    @Test
    fun getTest() {
        val userEntity = userJpaRepository.findById(1604)
        val user = UserEntity.toDomain(userEntity.orElseGet { UserEntity() })
        log.info("user: {}", user)

    }

    @Test
    fun createUser() {

    }
}