package com.kok1337.address.data.mapper

import com.kok1337.address.data.model.LocalForestryApiModel
import com.kok1337.address.domain.model.LocalForestry

internal object LocalForestryApiModelMapper {
    fun toModel(localForestryApiModel: LocalForestryApiModel): LocalForestry =
        LocalForestry(
            id = localForestryApiModel.id,
            name = localForestryApiModel.name,
        )
}