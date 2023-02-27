package com.kok1337.non_forest_land.internal.mapper

import com.kok1337.non_forest_land.api.NonForestLandApiModel
import com.kok1337.non_forest_land.api.model.NonForestLand

internal object NonForestLandMapper {
    fun fromApiModel(apiModel: NonForestLandApiModel): NonForestLand {
        return NonForestLand(apiModel.id, apiModel.name)
    }
}