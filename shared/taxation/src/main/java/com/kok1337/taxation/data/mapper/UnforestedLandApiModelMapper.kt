package com.kok1337.taxation.data.mapper

import com.kok1337.taxation.data.model.UnforestedLandApiModel
import com.kok1337.taxation.domain.model.UnforestedLand

internal object UnforestedLandApiModelMapper {
    fun toModel(unforestedLandApiModel: UnforestedLandApiModel): UnforestedLand {
        return UnforestedLand(unforestedLandApiModel.id, unforestedLandApiModel.name)
    }
}