package com.kok1337.age_group.internal.mapper

import com.kok1337.age_group.api.AgeGroupApiModel
import com.kok1337.age_group.api.model.AgeGroup

internal object AgeGroupMapper {
    fun fromApiModel(apiModel: AgeGroupApiModel): AgeGroup {
        return AgeGroup(apiModel.id, apiModel.name)
    }
}