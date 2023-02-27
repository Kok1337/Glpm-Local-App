package com.kok1337.land.internal.mapper

import com.kok1337.land.api.LandApiModel
import com.kok1337.land.api.model.Land

internal object LandMapper {
    fun fromApiModel(apiModel: LandApiModel): Land {
        return Land(apiModel.name, apiModel.isForestLand)
    }
}