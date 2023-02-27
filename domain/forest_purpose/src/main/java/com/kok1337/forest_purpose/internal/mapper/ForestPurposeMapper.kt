package com.kok1337.forest_purpose.internal.mapper

import com.kok1337.forest_purpose.api.ForestPurposeApiModel
import com.kok1337.forest_purpose.api.model.ForestPurpose

internal object ForestPurposeMapper {
    fun fromApiModel(apiModel: ForestPurposeApiModel): ForestPurpose {
        return ForestPurpose(apiModel.id, apiModel.name)
    }
}