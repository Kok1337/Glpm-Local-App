package com.kok1337.taxation.data.repository

import com.kok1337.taxation.data.data_source.termux.dao.TaxDao
import com.kok1337.taxation.data.mapper.TaxApiModelMapper
import com.kok1337.taxation.domain.model.Tax
import java.util.*

class TaxTermuxRepository(
    private val taxDao: TaxDao,
    private val taxLayerTermuxRepository: TaxLayerTermuxRepository,
    private val forestPurposeTermuxRepository: ForestPurposeTermuxRepository,
    private val protectionCategoryTermuxRepository: ProtectionCategoryTermuxRepository,
    private val ozuTermuxRepository: OzuTermuxRepository,
    private val bonitetTermuxRepository: BonitetTermuxRepository,
    private val nonForestLandTermuxRepository: NonForestLandTermuxRepository,
    private val unforestedLandTermuxRepository: UnforestedLandTermuxRepository,
    private val taxSourceTermuxRepository: TaxSourceTermuxRepository,
) {
    suspend fun findById(id: UUID): Tax {
        val taxApiModel = taxDao.getById(id) ?: throw IllegalStateException()
        val taxLayerList = taxLayerTermuxRepository.findAllByParentId(taxApiModel.id).toList()
        val forestPurpose = forestPurposeTermuxRepository.findById(taxApiModel.forestPurposeId)
        val protectionCategory =
            protectionCategoryTermuxRepository.findById(taxApiModel.protectionCategoryId)
        val ozu = ozuTermuxRepository.findById(taxApiModel.ozuId)
        val bonitet = bonitetTermuxRepository.findById(taxApiModel.bonitetId)
        val nonForestLand = nonForestLandTermuxRepository.findById(taxApiModel.nonForestLandId)
        val unforestedLand = unforestedLandTermuxRepository.findById(taxApiModel.unforestedLandId)
        val taxSource = taxSourceTermuxRepository.findById(taxApiModel.dataSourceId)
        return TaxApiModelMapper.toModel(
            taxApiModel = taxApiModel,
            forestPurpose = forestPurpose,
            taxLayerList = taxLayerList,
            protectionCategory = protectionCategory,
            ozu = ozu,
            bonitet = bonitet,
            nonForestLand = nonForestLand,
            unforestedLand = unforestedLand,
            taxSource = taxSource!!
        )
    }
}