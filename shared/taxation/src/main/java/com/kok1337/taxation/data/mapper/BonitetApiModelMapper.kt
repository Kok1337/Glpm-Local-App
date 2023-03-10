package com.kok1337.taxation.data.mapper

import com.kok1337.taxation.data.model.BonitetApiModel
import com.kok1337.taxation.domain.model.Bonitet

internal object BonitetApiModelMapper {
    fun toModel(bonitetApiModel: BonitetApiModel): Bonitet {
        return Bonitet(bonitetApiModel.id, bonitetApiModel.name)
    }
}