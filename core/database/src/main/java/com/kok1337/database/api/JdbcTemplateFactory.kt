package com.kok1337.database.api

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.DriverManagerDataSource

object JdbcTemplateFactory {
    fun create(dependencies: JdbcTemplateDependencies): JdbcTemplate {
        val jdbcTemplateDatasourceProvider = dependencies.jdbcTemplateDatasourceProvider
        val host = jdbcTemplateDatasourceProvider.host
        val port = jdbcTemplateDatasourceProvider.port
        val name = jdbcTemplateDatasourceProvider.name
        val username = jdbcTemplateDatasourceProvider.username
        val password = jdbcTemplateDatasourceProvider.password
        val driverName = jdbcTemplateDatasourceProvider.driverName
        val url = "jdbc:postgresql://${host}:${port}/${name}"
        val dataSource = DriverManagerDataSource(url, username, password)
        dataSource.setDriverClassName(driverName)
        return JdbcTemplate(dataSource)
    }
}