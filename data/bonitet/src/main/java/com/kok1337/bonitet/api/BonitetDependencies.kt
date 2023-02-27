package com.kok1337.bonitet.api

import org.springframework.jdbc.core.JdbcTemplate

interface BonitetDependencies {
    val jdbcTemplate: JdbcTemplate
}