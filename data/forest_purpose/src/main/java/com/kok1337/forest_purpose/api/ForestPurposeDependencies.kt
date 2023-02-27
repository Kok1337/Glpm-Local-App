package com.kok1337.forest_purpose.api

import org.springframework.jdbc.core.JdbcTemplate

interface ForestPurposeDependencies {
    val jdbcTemplate: JdbcTemplate
}