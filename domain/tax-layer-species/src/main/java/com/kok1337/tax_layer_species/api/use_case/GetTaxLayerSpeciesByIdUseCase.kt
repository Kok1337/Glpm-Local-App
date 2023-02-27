package com.kok1337.tax_layer_species.api.use_case

import com.kok1337.tax_layer_species.api.TaxLayerSpeciesRepository
import com.kok1337.tax_layer_species.api.model.TaxLayerSpecies
import com.kok1337.tax_layer_species.internal.mapper.TaxLayerSpeciesMapper
import java.util.*

class GetTaxLayerSpeciesByIdUseCase(
    private val taxLayerSpeciesRepository: TaxLayerSpeciesRepository,
) {
    suspend operator fun invoke(id: UUID): TaxLayerSpecies {
        val taxLayerSpeciesApiModel = taxLayerSpeciesRepository.findById(id)
        return TaxLayerSpeciesMapper.fromApiModel(taxLayerSpeciesApiModel)
    }
}