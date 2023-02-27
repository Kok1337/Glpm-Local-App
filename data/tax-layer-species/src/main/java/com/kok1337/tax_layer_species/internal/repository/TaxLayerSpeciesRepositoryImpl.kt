package com.kok1337.tax_layer_species.internal.repository

import com.kok1337.tax_layer_species.api.TaxLayerSpeciesApiModel
import com.kok1337.tax_layer_species.api.TaxLayerSpeciesRepository
import com.kok1337.tax_layer_species.internal.datasource.database.dao.TaxLayerSpeciesDao
import java.util.*

internal class TaxLayerSpeciesRepositoryImpl(
    private val taxLayerSpeciesDao: TaxLayerSpeciesDao,
) : TaxLayerSpeciesRepository {
    override suspend fun findById(id: UUID): TaxLayerSpeciesApiModel =
        taxLayerSpeciesDao.getById(id)

    override suspend fun findAllByParentId(parentId: UUID): List<TaxLayerSpeciesApiModel> =
        taxLayerSpeciesDao.getAllByParentId(parentId)
}