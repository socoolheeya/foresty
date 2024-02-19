package com.foresty.api.user.service

import com.foresty.domain.exposed.model.user.domain.User
import com.foresty.domain.jpa.model.user.UserEntity
import com.foresty.domain.jpa.repository.UserJpaRepository
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.transaction.annotation.Transactional


//@Transactional
//@SpringBootTest
//@ActiveProfiles("local")
//@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class SpringbootTestSupport

@SpringBootTest
class JpaTest (
    @Autowired var userJpaRepository: UserJpaRepository
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