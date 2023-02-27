package com.kok1337.tax.api.use_case

import com.kok1337.bonitet.api.use_case.GetBonitetByIdUseCase
import com.kok1337.forest_purpose.api.use_case.GetForestPurposeByIdUseCase
import com.kok1337.non_forest_land.api.use_case.GetNonForestLandByIdUseCase
import com.kok1337.ozu.api.use_case.GetOzuByIdUseCase
import com.kok1337.protection_category.api.use_case.GetProtectionCategoryByIdUseCase
import com.kok1337.tax.api.TaxRepository
import com.kok1337.tax.api.model.Tax
import com.kok1337.tax.internal.mapper.TaxMapper
import com.kok1337.tax_layer.api.use_case.GetAllTaxLayerByParentIdUseCase
import com.kok1337.unforested_land.api.use_case.GetUnforestedLandByIdUseCase
import java.util.*

class GetTaxByIdUseCase(
    private val taxRepository: TaxRepository,
    private val getForestPurposeByIdUseCase: GetForestPurposeByIdUseCase,
    private val getProtectionCategoryByIdUseCase: GetProtectionCategoryByIdUseCase,
    private val getOzuByIdUseCase: GetOzuByIdUseCase,
    private val getBonitetByIdUseCase: GetBonitetByIdUseCase,
    private val getUnforestedLandByIdUseCase: GetUnforestedLandByIdUseCase,
    private val getNonForestLandByIdUseCase: GetNonForestLandByIdUseCase,
    private val getAllTaxLayerByParentIdUseCase: GetAllTaxLayerByParentIdUseCase
) {
    suspend operator fun invoke(id: UUID): Tax {
        val taxApiModel = taxRepository.findById(id)
        val taxLayerList = getAllTaxLayerByParentIdUseCase(taxApiModel.id)
        val forestPurpose = taxApiModel.forestPurposeId?.let { getForestPurposeByIdUseCase(it) }
        val protectionCategory =
            taxApiModel.protectionCategoryId?.let { getProtectionCategoryByIdUseCase(it) }
        val ozu = taxApiModel.ozuId?.let { getOzuByIdUseCase(it) }
        val bonitet = taxApiModel.bonitetId?.let { getBonitetByIdUseCase(it) }
        val unforestedLand = taxApiModel.unforestedLandId?.let { getUnforestedLandByIdUseCase(it) }
        val nonForestLand = taxApiModel.nonForestLandId?.let { getNonForestLandByIdUseCase(it) }
        return TaxMapper.fromApiModel(
            taxApiModel,
            taxLayerList,
            forestPurpose,
            protectionCategory,
            ozu,
            bonitet,
            nonForestLand,
            unforestedLand
        )
    }
}