package com.kok1337.feature_ppn_taxation.internal.presentation.item

import com.kok1337.feature_ppn_taxation.internal.presentation.adapter.listitem_adapter.ListItem
import com.kok1337.species.api.model.Species
import com.kok1337.tax_layer_species.api.model.TaxLayerSpecies
import java.util.UUID

internal data class TaxLayerSpeciesItem(
    val taxLayerSpeciesId: UUID,
    val stock: Double?,
    val species: Species?,
    val coeff: Int?,
    val age: Int?,
    val height: Int?,
    val diameter: Int?,
) : ListItem