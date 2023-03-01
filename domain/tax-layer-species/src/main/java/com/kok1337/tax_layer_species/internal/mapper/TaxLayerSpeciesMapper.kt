package com.kok1337.tax_layer_species.internal.mapper

import com.kok1337.species.api.model.Species
import com.kok1337.tax_layer_species.api.TaxLayerSpeciesApiModel
import com.kok1337.tax_layer_species.api.model.TaxLayerSpecies

internal object TaxLayerSpeciesMapper {
    fun fromApiModel(apiModel: TaxLayerSpeciesApiModel): TaxLayerSpecies {
        val species = apiModel.speciesId?.let { Species(it, apiModel.nameShort, apiModel.name) }
        return TaxLayerSpecies(
            id = apiModel.id,
            parentId = apiModel.parentId,
            species = species,
            coeff = apiModel.coeff,
            age = apiModel.age,
            height = apiModel.height,
            diameter = apiModel.diameter,
            isMain = apiModel.isMain,
//            isExtra = apiModel.isExtra,
//            speciesNum = apiModel.speciesNum,
            gen = apiModel.gen,
//            stock = apiModel.stock,
            merchantabilityGroupId = apiModel.merchantabilityGroupId,
        )
    }

    fun toApiModel(model: TaxLayerSpecies, speciesNum: Int, stock: Int): TaxLayerSpeciesApiModel {
        return TaxLayerSpeciesApiModel(
            id = model.id,
            parentId = model.parentId,
            speciesId = model.species?.id,
            coeff = model.coeff,
            age = model.age,
            height = model.height,
            diameter = model.diameter,
            isMain = model.isMain,
            nameShort = model.species?.shortName ?: "",
            isExtra = model.isExtra,
            name = model.species?.fullName ?: "",
            speciesNum = speciesNum,
            gen = model.gen,
            stock = stock,
            merchantabilityGroupId = model.merchantabilityGroupId,
        )
    }
}