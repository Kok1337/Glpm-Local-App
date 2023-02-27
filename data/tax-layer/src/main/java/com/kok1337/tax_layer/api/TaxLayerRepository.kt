package com.kok1337.tax_layer.api

import java.util.*

interface TaxLayerRepository {
    suspend fun findAllByParentId(parentId: UUID): List<TaxLayerApiModel>
    suspend fun findById(id: UUID): TaxLayerApiModel
}