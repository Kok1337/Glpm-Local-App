package com.kok1337.feature_ppn_description.api.data.mapper

import com.kok1337.feature_ppn_description.api.data.model.SubForestryApiModel
import com.kok1337.feature_ppn_description.api.domain.module.SubForestry

internal object SubForestryApiModelMapper {
    fun toModel(subForestryApiModel: SubForestryApiModel): SubForestry {
        return SubForestry(
            id = subForestryApiModel.id,
            name = subForestryApiModel.name,
        )
    }
}