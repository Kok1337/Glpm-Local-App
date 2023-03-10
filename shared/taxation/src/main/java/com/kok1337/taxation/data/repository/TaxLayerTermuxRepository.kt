package com.kok1337.taxation.data.repository

import com.kok1337.taxation.data.data_source.termux.dao.TaxLayerDao
import com.kok1337.taxation.data.mapper.TaxLayerApiModelMapper
import com.kok1337.taxation.domain.model.TaxLayer
import java.util.*

class TaxLayerTermuxRepository(
    private val taxLayerDao: TaxLayerDao,
    private val taxSpeciesTermuxRepository: TaxSpeciesTermuxRepository,
    private val ageGroupTermuxRepository: AgeGroupTermuxRepository,
) {
    suspend fun findAllByParentId(taxId: UUID): Iterable<TaxLayer> {
        return taxLayerDao.getAllByParentId(taxId).map { taxLayerApiModel ->
            val taxSpeciesList =
                taxSpeciesTermuxRepository.findAllByParentId(taxLayerApiModel.id).toList()
            val ageGroup = ageGroupTermuxRepository.findById(taxLayerApiModel.ageGroupId)
            TaxLayerApiModelMapper.toModel(
                taxLayerApiModel = taxLayerApiModel,
                taxSpeciesList = taxSpeciesList,
                ageGroup = ageGroup,
            )
        }
    }
}