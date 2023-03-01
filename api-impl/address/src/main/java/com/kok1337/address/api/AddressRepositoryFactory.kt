package com.kok1337.address.api

import com.kok1337.address.api.repository.AddressRepository
import com.kok1337.address.di.AddressRepositoryDeps
import com.kok1337.address.di.DaggerAddressRepositoryComponent
import org.springframework.jdbc.core.JdbcTemplate

class AddressRepositoryFactory(
    private val jdbcTemplate: JdbcTemplate,
) {
    fun create(): AddressRepository {
        return DaggerAddressRepositoryComponent
            .factory()
            .create(DepsImpl(jdbcTemplate))
            .addressRepositoryImpl
    }

    internal inner class DepsImpl(override val jdbcTemplate: JdbcTemplate) : AddressRepositoryDeps
}