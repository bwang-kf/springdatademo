package com.example.springdatademo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.transaction.PlatformTransactionManager
import javax.sql.DataSource

@SpringBootApplication
@EnableJdbcRepositories
@Configuration
class SpringdatademoApplication {
    @Bean
    fun operations(): NamedParameterJdbcOperations = NamedParameterJdbcTemplate(dataSource())

    @Bean
    fun transactionManager(): PlatformTransactionManager = DataSourceTransactionManager(dataSource())

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "app.datasource")
    fun dataSource(): DataSource = DataSourceBuilder.create().build()
}

fun main(args: Array<String>) {
    runApplication<SpringdatademoApplication>(*args)
}
