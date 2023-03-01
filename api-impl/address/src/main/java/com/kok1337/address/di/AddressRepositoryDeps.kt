package com.kok1337.address.di

import org.springframework.jdbc.core.JdbcTemplate

internal interface AddressRepositoryDeps {
    val jdbcTemplate: JdbcTemplate
}