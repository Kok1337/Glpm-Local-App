package com.kok1337.tax_layer.api

import com.kok1337.tax_layer.internal.datasource.database.dao.TaxLayerDao
import com.kok1337.tax_layer.internal.repository.TaxLayerRepositoryImpl

object TaxLayerRepositoryFactory {
    fun create(dependencies: TaxLayerDependencies): TaxLayerRepository {
        val jdbcTemplate = dependencies.jdbcTemplate
        val taxLayerDao = TaxLayerDao(jdbcTemplate)
        return TaxLayerRepositoryImpl(taxLayerDao)
    }
}