package com.kok1337.district.internal.di

import org.springframework.jdbc.core.JdbcTemplate

interface DistrictRepositoryDeps {
    val jdbcTemplate: JdbcTemplate
}