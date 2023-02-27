package com.kok1337.unforested_land.internal.mapper

import com.kok1337.unforested_land.api.UnforestedLandApiModel
import com.kok1337.unforested_land.api.model.UnforestedLand

internal object UnforestedLandMapper {
    fun fromApiModel(apiModel: UnforestedLandApiModel): UnforestedLand {
        return UnforestedLand(apiModel.id, apiModel.name)
    }
}