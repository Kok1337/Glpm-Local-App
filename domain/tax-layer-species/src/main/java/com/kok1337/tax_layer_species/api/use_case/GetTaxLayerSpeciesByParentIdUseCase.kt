package com.kok1337.tax_layer_species.api.use_case

import com.kok1337.tax_layer_species.api.TaxLayerSpeciesRepository
import com.kok1337.tax_layer_species.api.model.TaxLayerSpecies
import com.kok1337.tax_layer_species.internal.mapper.TaxLayerSpeciesMapper
import java.util.*

class GetTaxLayerSpeciesByParentIdUseCase(
    private val taxLayerSpeciesRepository: TaxLayerSpeciesRepository,
) {
    suspend operator fun invoke(parentId: UUID): List<TaxLayerSpecies> {
        val taxLayerSpeciesApiModelList = taxLayerSpeciesRepository.findAllByParentId(parentId)
        return taxLayerSpeciesApiModelList.map { TaxLayerSpeciesMapper.fromApiModel(it) }
    }
}