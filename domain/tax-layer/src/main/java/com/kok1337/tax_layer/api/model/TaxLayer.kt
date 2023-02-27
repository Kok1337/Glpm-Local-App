package com.kok1337.tax_layer.api.model

import com.kok1337.age_group.api.model.AgeGroup
import com.kok1337.tax_layer_species.api.model.TaxLayerSpecies
import java.util.*

data class TaxLayer(
    val id: UUID,
    val parentId: UUID,

    val taxLayerSpeciesList: List<TaxLayerSpecies>,
    val ageGroup: AgeGroup? = null,

//    val layer: Int? = null,
//    val composition: String? = null,
    val fullness: Double? = null,
    val stock: Double? = null,
    val ageClass: Int? = null,
    val height: Int? = null,
    val layerTypeId: Int? = 1,
    val age: Int? = null,
    val density: Double? = null,
    val condition: String? = null,
) {
    val composition: String

    init {
        composition = ""
    }

//    private fun buildComposition() {}
}