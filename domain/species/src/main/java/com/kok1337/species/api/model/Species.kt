package com.kok1337.species.api.model

import com.kok1337.species.api.SpeciesApiModel

data class Species(
    val id: Int,
    val shortName: String,
    val fullName: String,
) {
    internal fun toApiModel(): SpeciesApiModel = SpeciesApiModel(
        id, shortName, fullName
    )
}