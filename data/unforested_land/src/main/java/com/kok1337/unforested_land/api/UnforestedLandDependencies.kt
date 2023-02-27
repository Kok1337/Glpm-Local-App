package com.kok1337.unforested_land.api

import org.springframework.jdbc.core.JdbcTemplate

interface UnforestedLandDependencies {
    val jdbcTemplate: JdbcTemplate
}