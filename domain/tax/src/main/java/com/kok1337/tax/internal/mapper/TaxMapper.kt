package com.kok1337.tax.internal.mapper

import com.kok1337.bonitet.api.model.Bonitet
import com.kok1337.forest_purpose.api.model.ForestPurpose
import com.kok1337.non_forest_land.api.model.NonForestLand
import com.kok1337.ozu.api.model.Ozu
import com.kok1337.protection_category.api.model.ProtectionCategory
import com.kok1337.tax.api.TaxApiModel
import com.kok1337.tax.api.model.Tax
import com.kok1337.tax_layer.api.model.TaxLayer
import com.kok1337.unforested_land.api.model.UnforestedLand

internal object TaxMapper {
    fun toApiModel(model: Tax): TaxApiModel {
        return TaxApiModel(
            id = model.id,
            localityId = model.localityId,
            section = model.section,
            forestPurposeId = model.forestPurpose?.id,
            protectionCategoryId = model.protectionCategory?.id,
            ozuId = model.ozu?.id,
            ooptId = model.ooptId,
            isWaterProtectionZone = model.isWaterProtectionZone,
            tenant = model.tenant,
            leaseContractNum = model.leaseContractNum,
            leaseContractDate = model.leaseContractDate,
            leaseTypeId = model.leaseTypeId,
            cadastralNum = model.cadastralNum,
            firePrescription = model.firePrescription,
            forestUseId = model.forestUseId,
            s = model.s,
            forestInventoryYear = model.forestInventoryYear,
            forestType = model.forestType,
            tluId = model.tluId,
            landCatId = model.landCatId,
            bonitetId = model.bonitet?.id,
            underwood = model.underwood,
            isNatural = model.isNatural,
            leaseContractTypeId = model.leaseContractTypeId,
            forestZoneId = model.forestZoneId,
            isArtificial = model.isArtificial,
            plantingYear = model.plantingYear,
            isAfterTapping = model.isAfterTapping,
            tabZoneId = model.tabZoneId,
            tlu = model.tlu,
            isDrained = model.isDrained,
            ageGroupId = model.ageGroupId,
            isFireBurned = model.isFireBurned,
            radioactiveZoneId = model.radioactiveZoneId,
            stockDead = model.stockDead,
            stockOpenStand = model.stockOpenStand,
            stockSingleTree = model.stockSingleTree,
            stockFellingDebris = model.stockFellingDebris,
            stockLiquidDebris = model.stockLiquidDebris,
            nonForestLandId = model.nonForestLand?.id,
            unforestedLandId = model.unforestedLand?.id,
            isDraft = model.isDraft,
            dataSourceId = model.dataSourceId,
            isNewDead = model.isNewDead,
            oopt = model.oopt,
//            ozu = model.ozu,
            forestUse = model.forestUse,
            stockSection = model.stockSection,
        )
    }

    fun fromApiModel(
        apiModel: TaxApiModel,
        taxLayerList: List<TaxLayer>,
        forestPurpose: ForestPurpose?,
        protectionCategory: ProtectionCategory?,
        ozu: Ozu?,
        bonitet: Bonitet?,
        nonForestLand: NonForestLand?,
        unforestedLand: UnforestedLand?,
    ): Tax {
        return Tax(
            id = apiModel.id,
            localityId = apiModel.localityId,
            section = apiModel.section,
            forestPurpose = forestPurpose,
            protectionCategory = protectionCategory,
            ozu = ozu,
            ooptId = apiModel.ooptId,
            isWaterProtectionZone = apiModel.isWaterProtectionZone,
            tenant = apiModel.tenant,
            leaseContractNum = apiModel.leaseContractNum,
            leaseContractDate = apiModel.leaseContractDate,
            leaseTypeId = apiModel.leaseTypeId,
            cadastralNum = apiModel.cadastralNum,
            firePrescription = apiModel.firePrescription,
            forestUseId = apiModel.forestUseId,
            s = apiModel.s,
            forestInventoryYear = apiModel.forestInventoryYear,
            forestType = apiModel.forestType,
            tluId = apiModel.tluId,
            landCatId = apiModel.landCatId,
            bonitet = bonitet,
            underwood = apiModel.underwood,
            isNatural = apiModel.isNatural,
            leaseContractTypeId = apiModel.leaseContractTypeId,
            forestZoneId = apiModel.forestZoneId,
            isArtificial = apiModel.isArtificial,
            plantingYear = apiModel.plantingYear,
            isAfterTapping = apiModel.isAfterTapping,
            tabZoneId = apiModel.tabZoneId,
            tlu = apiModel.tlu,
            isDrained = apiModel.isDrained,
            ageGroupId = apiModel.ageGroupId,
            isFireBurned = apiModel.isFireBurned,
            radioactiveZoneId = apiModel.radioactiveZoneId,
            stockDead = apiModel.stockDead,
            stockOpenStand = apiModel.stockOpenStand,
            stockSingleTree = apiModel.stockSingleTree,
            stockFellingDebris = apiModel.stockFellingDebris,
            stockLiquidDebris = apiModel.stockLiquidDebris,
            nonForestLand = nonForestLand,
            unforestedLand = unforestedLand,
            isDraft = apiModel.isDraft,
            dataSourceId = apiModel.dataSourceId,
            isNewDead = apiModel.isNewDead,
            oopt = apiModel.oopt,
//            ozu = apiModel.ozu,
            forestUse = apiModel.forestUse,
            stockSection = apiModel.stockSection,
            taxLayerList = taxLayerList
        )
    }
}