package com.kok1337.species.internal.mapper

import com.kok1337.species.api.SpeciesApiModel
import com.kok1337.species.api.model.Species

internal object SpeciesMapper {
    fun fromApiModel(apiModel: SpeciesApiModel): Species {
        return Species(
            id = apiModel.id,
            shortName = apiModel.shortName,
            fullName = apiModel.fullName
        )
    }

    fun fromApiModel(model: Species): SpeciesApiModel {
        return SpeciesApiModel(
            id = model.id,
            shortName = model.shortName,
            fullName = model.fullName
        )
    }
}