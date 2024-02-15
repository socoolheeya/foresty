package com.foresty.api

import com.foresty.domain.entities.user.dao.UserDao
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.junit.jupiter.api.Test
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

        println("---------------------------------------")
        println(users)
    }

    @Test
    fun deleteTest() {
        Database.connect(getDataSource())

        val userDao = UserDao.findById(1602);
        val user = userDao?.toDomain()

        println("---------------------------------------")
        println(user)

        userDao?.delete()
    }


}