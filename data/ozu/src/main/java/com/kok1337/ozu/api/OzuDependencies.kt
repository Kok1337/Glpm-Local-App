package com.kok1337.ozu.api

import org.springframework.jdbc.core.JdbcTemplate

interface OzuDependencies {
    val jdbcTemplate: JdbcTemplate
}