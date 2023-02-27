package com.kok1337.feature_ppn_taxation_sample.di

import org.springframework.jdbc.core.JdbcTemplate

interface FeaturePpnTaxationActivityDependencies {
    val jdbcTemplate: JdbcTemplate
}