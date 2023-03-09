package com.kok1337.address.data.mapper

import com.kok1337.address.data.model.ForestryApiModel
import com.kok1337.address.domain.model.Forestry

internal object ForestryApiModelMapper {
    fun toModel(forestryApiModel: ForestryApiModel): Forestry =
        Forestry(
            id = forestryApiModel.id,
            name = forestryApiModel.name,
        )
}