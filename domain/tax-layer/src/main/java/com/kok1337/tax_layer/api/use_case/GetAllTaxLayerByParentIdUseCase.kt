package com.kok1337.tax_layer.api.use_case

import com.kok1337.age_group.api.use_case.GetAgeGroupByIdUseCase
import com.kok1337.tax_layer.api.TaxLayerRepository
import com.kok1337.tax_layer.api.model.TaxLayer
import com.kok1337.tax_layer.internal.mapper.TaxLayerMapper
import com.kok1337.tax_layer_species.api.use_case.GetAllTaxLayerSpeciesByParentIdUseCase
import java.util.*

class GetAllTaxLayerByParentIdUseCase(
    private val taxLayerRepository: TaxLayerRepository,
    private val getAgeGroupByIdUseCase: GetAgeGroupByIdUseCase,
    private val getAllTaxLayerSpeciesByParentIdUseCase: GetAllTaxLayerSpeciesByParentIdUseCase
) {
    suspend operator fun invoke(id: UUID): List<TaxLayer> {
        val taxLayerApiModelList = taxLayerRepository.findAllByParentId(id)
        return taxLayerApiModelList.map { taxLayerApiModel ->
            val taxLayerSpeciesList = getAllTaxLayerSpeciesByParentIdUseCase(taxLayerApiModel.id)
            val ageGroup = taxLayerApiModel.ageGroupId?.let { getAgeGroupByIdUseCase(it) }
            TaxLayerMapper.fromApiModel(taxLayerApiModel, taxLayerSpeciesList, ageGroup)
        }
    }
}