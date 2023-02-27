package com.kok1337.protection_category.api

import org.springframework.jdbc.core.JdbcTemplate

interface ProtectionCategoryDependencies {
    val jdbcTemplate: JdbcTemplate
}