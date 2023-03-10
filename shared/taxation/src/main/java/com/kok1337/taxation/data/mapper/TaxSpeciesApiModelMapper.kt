package com.kok1337.taxation.data.mapper

import com.kok1337.species.domain.model.Species
import com.kok1337.taxation.data.model.TaxSpeciesApiModel
import com.kok1337.taxation.domain.model.TaxSpecies

internal object TaxSpeciesApiModelMapper {
    fun toModel(taxSpeciesApiModel: TaxSpeciesApiModel): TaxSpecies {
        val species = taxSpeciesApiModel.speciesId?.let {
            Species(
                it,
                taxSpeciesApiModel.nameShort,
                taxSpeciesApiModel.name
            )
        }
        return TaxSpecies(
            id = taxSpeciesApiModel.id,
            parentId = taxSpeciesApiModel.parentId,
            species = species,
            coeff = taxSpeciesApiModel.coeff,
            age = taxSpeciesApiModel.age,
            height = taxSpeciesApiModel.height,
            diameter = taxSpeciesApiModel.diameter,
        )
    }
}