package com.foresty.domain.configuration

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import jakarta.persistence.EntityManager
import jakarta.persistence.EntityManagerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import java.util.Properties
import javax.sql.DataSource

@Configuration
@EnableJpaRepositories(basePackages = ["com.foresty.domain.jpa.repository"])
class JpaConfiguration {

    @Bean
    fun dataSource(): DataSource {
        val config  = HikariConfig().apply {
            jdbcUrl = "jdbc:mariadb://localhost:3306/foresty"
            driverClassName = "org.mariadb.jdbc.Driver"
            username = "root"
            password = "1234"
            maximumPoolSize = 10
            isReadOnly = false
            transactionIsolation = "TRANSACTION_SERIALIZABLE"
        }

        return  HikariDataSource(config)
    }

    @Bean
    fun entityManagerFactory(): LocalContainerEntityManagerFactoryBean {
        val emf: LocalContainerEntityManagerFactoryBean = LocalContainerEntityManagerFactoryBean()
        emf.setPackagesToScan("com.foresty.domain")
        emf.jpaVendorAdapter = HibernateJpaVendorAdapter()
        emf.dataSource = dataSource()
        emf.setJpaProperties(jpaProperties())

        return emf
    }

    private fun jpaProperties(): Properties {
        val properties: Properties = Properties()
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MariaDBDialect")


        return properties;
    }

    @Bean
    fun entityManager(entityManagerFactory: EntityManagerFactory): EntityManager {
        return entityManagerFactory.createEntityManager()
    }
}