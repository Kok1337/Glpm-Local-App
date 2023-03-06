package com.kok1337.feature_ppn_description.api.data.mapper

import com.kok1337.feature_ppn_description.api.data.model.ForestryApiModel
import com.kok1337.feature_ppn_description.api.domain.module.Forestry

internal object ForestryApiModelMapper {
    fun toModel(forestryApiModel: ForestryApiModel): Forestry =
        Forestry(
            id = forestryApiModel.id,
            name = forestryApiModel.name,
        )
}