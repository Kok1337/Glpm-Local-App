package com.kok1337.tax_layer_species.api.model

import com.kok1337.species.api.model.Species
import com.kok1337.tax_layer_species.api.TaxLayerSpeciesApiModel
import java.util.*

data class TaxLayerSpecies(
    val id: UUID,
    val parentId: UUID,
    val species: Species? = null,
    val coeff: Int? = null,
    val age: Int? = null,
    val height: Int? = null,
    val diameter: Int? = null,
    val isMain: Boolean? = null,
//    val speciesNum: Int? = null,
    val gen: Int = 1,
//    val stock: Int? = null,
    val merchantabilityGroupId: Int? = null,
) {
    val isExtra: Boolean = coeff == null || coeff == 0
}