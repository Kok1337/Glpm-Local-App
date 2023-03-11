package com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.item

import com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.TaxationItem
import com.kok1337.species.domain.model.Species
import java.util.*

internal data class TaxSpeciesItem(
    val taxLayerSpeciesId: UUID,
    val stock: Double?,
    val species: Species?,
    val coeff: Int?,
    val age: Int?,
    val height: Int?,
    val diameter: Int?,
) : TaxationItem