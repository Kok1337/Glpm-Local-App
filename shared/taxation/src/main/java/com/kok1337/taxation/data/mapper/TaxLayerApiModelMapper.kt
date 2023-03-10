package com.kok1337.taxation.data.mapper

import com.kok1337.taxation.data.model.TaxLayerApiModel
import com.kok1337.taxation.domain.model.AgeGroup
import com.kok1337.taxation.domain.model.TaxLayer
import com.kok1337.taxation.domain.model.TaxSpecies

internal object TaxLayerApiModelMapper {
    fun toModel(
        taxLayerApiModel: TaxLayerApiModel,
        taxSpeciesList: List<TaxSpecies>,
        ageGroup: AgeGroup?
    ): TaxLayer {
        return TaxLayer(
            id = taxLayerApiModel.id,
            parentId = taxLayerApiModel.parentId,
            fullness = taxLayerApiModel.fullness,
            stock = taxLayerApiModel.stock,
            ageClass = taxLayerApiModel.ageClass,
            ageGroup = ageGroup,
            height = taxLayerApiModel.height,
            age = taxLayerApiModel.age,
            taxSpeciesList = taxSpeciesList,
        )
    }
}