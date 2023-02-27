package com.kok1337.age_group.api

import org.springframework.jdbc.core.JdbcTemplate

interface AgeGroupDependencies {
    val jdbcTemplate: JdbcTemplate
}