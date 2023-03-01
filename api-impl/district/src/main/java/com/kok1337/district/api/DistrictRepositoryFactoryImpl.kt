package com.kok1337.district.api

import com.kok1337.district.api.repository.DistrictRepository
import com.kok1337.district.api.repository.DistrictRepositoryFactory
import com.kok1337.district.internal.di.DaggerDistrictRepositoryComponent
import com.kok1337.district.internal.di.DistrictRepositoryDeps
import org.springframework.jdbc.core.JdbcTemplate

class DistrictRepositoryFactoryImpl(
    private val jdbcTemplate: JdbcTemplate,
) : DistrictRepositoryFactory {
    override fun create(): DistrictRepository {
        return DaggerDistrictRepositoryComponent
            .factory()
            .create(DepsImpl(jdbcTemplate))
            .districtRepositoryImpl
    }

    internal inner class DepsImpl(override val jdbcTemplate: JdbcTemplate) : DistrictRepositoryDeps
}