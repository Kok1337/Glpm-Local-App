package com.kok1337.tax_layer_species.api

import org.springframework.jdbc.core.JdbcTemplate

interface TaxLayerSpeciesDependencies {
    val jdbcTemplate: JdbcTemplate
    val userIdProvider: UserIdProvider
}

interface UserIdProvider {
    val userId: Int
}