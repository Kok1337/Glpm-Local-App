package com.kok1337.tax_layer_species.api

import java.util.UUID

interface TaxLayerSpeciesRepository {
    suspend fun findById(id: UUID): TaxLayerSpeciesApiModel
    suspend fun findAllByParentId(parentId: UUID): List<TaxLayerSpeciesApiModel>
}