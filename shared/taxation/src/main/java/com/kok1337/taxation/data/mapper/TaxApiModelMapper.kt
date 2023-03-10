package com.kok1337.taxation.data.mapper

import com.kok1337.taxation.data.model.TaxApiModel
import com.kok1337.taxation.domain.model.*

internal object TaxApiModelMapper {
    fun toModel(
        taxApiModel: TaxApiModel,
        taxLayerList: List<TaxLayer>,
        forestPurpose: ForestPurpose?,
        protectionCategory: ProtectionCategory?,
        ozu: Ozu?,
        bonitet: Bonitet?,
        nonForestLand: NonForestLand?,
        unforestedLand: UnforestedLand?,
        taxSource: TaxSource,
    ): Tax {
        return Tax(
            id = taxApiModel.id,
            localityId = taxApiModel.localityId,
            section = taxApiModel.section,
            forestPurpose = forestPurpose,
            protectionCategory = protectionCategory,
            ozu = ozu,
            s = taxApiModel.s,
            forestType = taxApiModel.forestType,
            bonitet = bonitet,
            nonForestLand = nonForestLand,
            unforestedLand = unforestedLand,
            taxLayerList = taxLayerList,
            taxSource = taxSource
        )
    }

    fun toModel(
        taxApiModel: TaxApiModel,
        taxSource: TaxSource,
    ): TaxPreview {
        return TaxPreview(
            id = taxApiModel.id,
            s = taxApiModel.s,
            forestInventoryYear = taxApiModel.forestInventoryYear,
            taxSource = taxSource,
        )
    }
}