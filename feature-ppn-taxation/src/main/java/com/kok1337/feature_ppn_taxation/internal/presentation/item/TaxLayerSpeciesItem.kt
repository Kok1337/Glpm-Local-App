package com.kok1337.feature_ppn_taxation.internal.presentation.item

import com.kok1337.feature_ppn_taxation.internal.presentation.adapter.ListItem
import com.kok1337.species.api.model.Species
import com.kok1337.tax_layer_species.api.model.TaxLayerSpecies

internal data class TaxLayerSpeciesItem(
    val taxLayerSpecies: TaxLayerSpecies,
    val stock: Double?
) : ListItem {
    val species: Species? = taxLayerSpecies.species
    val coeff: Int? = taxLayerSpecies.coeff
    val age: Int? = taxLayerSpecies.age
    val height: Int? = taxLayerSpecies.height
    val diameter: Int? = taxLayerSpecies.diameter
}