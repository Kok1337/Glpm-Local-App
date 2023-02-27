package com.kok1337.tax_layer.api

import org.springframework.jdbc.core.JdbcTemplate

interface TaxLayerDependencies {
    val jdbcTemplate: JdbcTemplate
}