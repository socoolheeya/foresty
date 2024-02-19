package com.foresty.api.user.service

import com.foresty.api.commons.utils.DateUtils
import com.foresty.domain.exposed.model.user.dao.UserDao
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import java.util.*

//@Transactional
@SpringBootTest
@ActiveProfiles("local")
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class ExposedTestSupport


class UserServiceTest {

    private fun getDataSource(): HikariDataSource {
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
    fun createTest() {
        Database.connect(getDataSource())

        transaction {
            (1..10000).forEach {
                var randomName = "hong_$it";
                if(it % 2 == 0) {
                    randomName = "park_$it"
                }
                val newUser = UserDao.new {
                    name = randomName
                    nickName = randomName + "_tester"
                    password = UUID.randomUUID().toString()
                    email = "hello.exposed_$it@gmail.com"
                    createdBy = randomName
                    createdDate = DateUtils.javaNow()
                    updatedBy = randomName
                    updatedDate = DateUtils.javaNow()
                }
            }
        }


    }

}