package com.kok1337.bonitet.internal.mapper

import com.kok1337.bonitet.api.BonitetApiModel
import com.kok1337.bonitet.api.model.Bonitet

internal object BonitetMapper {
    fun fromApiModel(apiModel: BonitetApiModel): Bonitet {
        return Bonitet(apiModel.id, apiModel.name)
    }
}