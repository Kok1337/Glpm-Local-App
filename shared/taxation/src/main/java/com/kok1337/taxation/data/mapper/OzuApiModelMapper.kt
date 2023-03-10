package com.kok1337.taxation.data.mapper

import com.kok1337.taxation.data.model.OzuApiModel
import com.kok1337.taxation.domain.model.Ozu

internal object OzuApiModelMapper {
    fun toModel(ozuApiModel: OzuApiModel): Ozu {
        return Ozu(ozuApiModel.id, ozuApiModel.name)
    }
}