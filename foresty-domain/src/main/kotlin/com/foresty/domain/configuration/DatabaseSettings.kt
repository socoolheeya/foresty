package com.foresty.domain.configuration

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database

object DatabaseSettings {
    private val config  = HikariConfig().apply {
        jdbcUrl = "jdbc:mysql://localhost:3306/foresty"
        driverClassName = "com.mysql.cj.jdbc.Driver"
        username = "root"
        password = "1234"
        maximumPoolSize = 10
        isReadOnly = false
        transactionIsolation = "TRANSACTION_SERIALIZABLE"
    }

    private val dataSource = HikariDataSource(config)

    val db by lazy {
        Database.connect(dataSource)
    }
}