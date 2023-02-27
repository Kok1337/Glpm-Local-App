package com.kok1337.tax.api

import org.springframework.jdbc.core.JdbcTemplate

interface TaxDependencies {
    val jdbcTemplate: JdbcTemplate
}