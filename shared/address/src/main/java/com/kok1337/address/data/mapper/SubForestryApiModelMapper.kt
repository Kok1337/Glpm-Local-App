package com.kok1337.address.data.mapper

import com.kok1337.address.data.model.SubForestryApiModel
import com.kok1337.address.domain.model.SubForestry

internal object SubForestryApiModelMapper {
    fun toModel(subForestryApiModel: SubForestryApiModel): SubForestry {
        return SubForestry(
            id = subForestryApiModel.id,
            name = subForestryApiModel.name,
        )
    }
}