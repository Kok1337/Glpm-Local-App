package com.kok1337.taxation.data.mapper

import com.kok1337.taxation.data.model.NonForestLandApiModel
import com.kok1337.taxation.domain.model.NonForestLand

internal object NonForestLandApiModelMapper {
    fun toModel(nonForestLandApiModel: NonForestLandApiModel): NonForestLand {
        return NonForestLand(nonForestLandApiModel.id, nonForestLandApiModel.name)
    }
}