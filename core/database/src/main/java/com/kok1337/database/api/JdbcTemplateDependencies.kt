package com.kok1337.database.api

interface JdbcTemplateDependencies {
    val jdbcTemplateDatasourceProvider: JdbcTemplateDatasourceProvider
}

interface JdbcTemplateDatasourceProvider {
    val host: String
    val port: String
    val name: String
    val username: String
    val password: String
    val driverName: String
}

