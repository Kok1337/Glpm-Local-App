package com.kok1337.tax_layer.internal.mapper

import com.kok1337.age_group.api.model.AgeGroup
import com.kok1337.tax_layer.api.TaxLayerApiModel
import com.kok1337.tax_layer.api.model.TaxLayer
import com.kok1337.tax_layer_species.api.model.TaxLayerSpecies

internal object TaxLayerMapper {
    fun fromApiModel(
        apiModel: TaxLayerApiModel,
        taxLayerSpeciesList: List<TaxLayerSpecies>,
        ageGroup: AgeGroup?
    ): TaxLayer {
        return TaxLayer(
            id = apiModel.id,
            parentId = apiModel.parentId,
//            layer = apiModel.layer,
//            composition = apiModel.composition,
            fullness = apiModel.fullness,
            stock = apiModel.stock,
            ageClass = apiModel.ageClass,
            ageGroup = ageGroup,
            height = apiModel.height,
            layerTypeId = apiModel.layerTypeId,
            age = apiModel.age,
            density = apiModel.density,
            condition = apiModel.condition,
            taxLayerSpeciesList = taxLayerSpeciesList,
        )
    }

    fun toApiModel(model: TaxLayer, layer: Int): TaxLayerApiModel {
        return TaxLayerApiModel(
            id = model.id,
            parentId = model.parentId,
            layer = layer,
            composition = model.composition,
            fullness = model.fullness,
            stock = model.stock,
            ageClass = model.ageClass,
            ageGroupId = model.ageGroup?.id,
            height = model.height,
            layerTypeId = model.layerTypeId,
            age = model.age,
            density = model.density,
            condition = model.condition,
        )
    }
}