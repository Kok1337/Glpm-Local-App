package com.kok1337.ozu.internal.mapper

import com.kok1337.ozu.api.OzuApiModel
import com.kok1337.ozu.api.model.Ozu

internal object OzuMapper {
    fun fromApiModel(apiModel: OzuApiModel): Ozu {
        return Ozu(apiModel.id, apiModel.name)
    }
}