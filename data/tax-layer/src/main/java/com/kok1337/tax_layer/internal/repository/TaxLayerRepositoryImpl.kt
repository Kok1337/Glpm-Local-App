package com.kok1337.tax_layer.internal.repository

import com.kok1337.tax_layer.api.TaxLayerApiModel
import com.kok1337.tax_layer.api.TaxLayerRepository
import com.kok1337.tax_layer.internal.datasource.database.dao.TaxLayerDao
import java.util.*

internal class TaxLayerRepositoryImpl(
    private val taxLayerDao: TaxLayerDao,
) : TaxLayerRepository {
    override suspend fun findAllByParentId(parentId: UUID): List<TaxLayerApiModel> =
        taxLayerDao.getAllByParentId(parentId)

    override suspend fun findById(id: UUID): TaxLayerApiModel =
        taxLayerDao.getById(id)
}