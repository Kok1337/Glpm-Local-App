package com.kok1337.non_forest_land.api

import org.springframework.jdbc.core.JdbcTemplate

interface NonForestLandDependencies {
    val jdbcTemplate: JdbcTemplate
}