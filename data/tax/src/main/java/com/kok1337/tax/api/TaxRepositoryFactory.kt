package com.kok1337.tax.api

import com.kok1337.tax.internal.datasource.database.dao.TaxDao
import com.kok1337.tax.internal.repository.TaxRepositoryImpl

object TaxRepositoryFactory {
    fun create(dependencies: TaxDependencies): TaxRepository {
        val jdbcTemplate = dependencies.jdbcTemplate
        val taxDao = TaxDao(jdbcTemplate)
        return TaxRepositoryImpl(taxDao)
    }
}