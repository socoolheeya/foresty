package com.foresty.api

import com.foresty.api.commons.utils.DateUtils
import com.foresty.domain.exposed.model.user.dao.UserDao
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import org.springframework.transaction.annotation.Transactional

@Transactional
@SpringBootTest
@ActiveProfiles("local")
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
open class ExposedTestSupport

class UserDaoTest: ExposedTestSupport() {

    val log: Logger = LoggerFactory.getLogger(UserDaoTest::class.java)

    private fun getDataSource():HikariDataSource {
        val config  = HikariConfig().apply {
            jdbcUrl = "jdbc:mariadb://localhost:3306/foresty"
            driverClassName = "org.mariadb.jdbc.Driver"
            username = "root"
            password = "1234"
            maximumPoolSize = 10
            isReadOnly = false
            transactionIsolation = "TRANSACTION_SERIALIZABLE"
        }

        return HikariDataSource(config)
    }

    @Test
    fun selectTest() {
        Database.connect(getDataSource())

        val users = UserDao.all().toList()
            .forEach { user ->
                println("##users : " + user.toDomain())
            }

        log.info("---------------------------------------")
        println(users)
    }

    @Test
    fun createTest() {
        Database.connect(getDataSource())
        val newUser = UserDao.new {
            name = "hong"
            password = "1234"
            email = "hello.exposed@gmail.com"
            createdBy = "exposed tester"
            createdDate = DateUtils.javaNow()
            updatedBy = "exposed tester"
            updatedDate = DateUtils.javaNow()
        }

        log.info("new User : {}", newUser.toDomain())
        //val userDao = UserDao.findById(1608);
    }

    @Test
    fun updateTest() {
        Database.connect(getDataSource())
        val userDao = UserDao.findById(1611);
    }

    @Test
    fun deleteTest() {
        Database.connect(getDataSource())

        val userDao = UserDao.findById(1602);
        val user = userDao?.toDomain()

        println(user)

        userDao?.delete()
    }
}