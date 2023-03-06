package com.kok1337.feature_ppn_description.api.data.mapper

import com.kok1337.feature_ppn_description.api.data.model.LocalForestryApiModel
import com.kok1337.feature_ppn_description.api.domain.module.LocalForestry

internal object LocalForestryApiModelMapper {
    fun toModel(localForestryApiModel: LocalForestryApiModel): LocalForestry =
        LocalForestry(
            id = localForestryApiModel.id,
            name = localForestryApiModel.name,
        )
}