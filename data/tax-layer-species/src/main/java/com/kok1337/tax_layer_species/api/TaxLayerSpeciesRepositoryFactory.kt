package com.kok1337.tax_layer_species.api

import com.kok1337.tax_layer_species.internal.datasource.database.dao.TaxLayerSpeciesDao
import com.kok1337.tax_layer_species.internal.repository.TaxLayerSpeciesRepositoryImpl

object TaxLayerSpeciesRepositoryFactory {
    fun create(dependencies: TaxLayerSpeciesDependencies): TaxLayerSpeciesRepository {
        val jdbcTemplate = dependencies.jdbcTemplate
        val userIdProvider = dependencies.userIdProvider
        val taxLayerSpeciesDao = TaxLayerSpeciesDao(jdbcTemplate, userIdProvider)
        return TaxLayerSpeciesRepositoryImpl(taxLayerSpeciesDao)
    }
}