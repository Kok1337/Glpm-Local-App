package com.kok1337.taxation.data.mapper

import com.kok1337.taxation.data.model.ForestPurposeApiModel
import com.kok1337.taxation.domain.model.ForestPurpose

internal object ForestPurposeApiModelMapper {
    fun toModel(forestPurposeApiModel: ForestPurposeApiModel): ForestPurpose {
        return ForestPurpose(forestPurposeApiModel.id, forestPurposeApiModel.name)
    }
}