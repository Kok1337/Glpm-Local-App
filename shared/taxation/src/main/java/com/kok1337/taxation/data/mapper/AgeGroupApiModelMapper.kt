package com.kok1337.taxation.data.mapper

import com.kok1337.taxation.data.model.AgeGroupApiModel
import com.kok1337.taxation.domain.model.AgeGroup

internal object AgeGroupApiModelMapper{
    fun toModel(ageGroupApiModel: AgeGroupApiModel): AgeGroup {
        return AgeGroup(ageGroupApiModel.id, ageGroupApiModel.name)
    }
}