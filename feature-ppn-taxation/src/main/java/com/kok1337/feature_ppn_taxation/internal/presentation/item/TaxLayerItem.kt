package com.kok1337.feature_ppn_taxation.internal.presentation.item

import com.kok1337.age_group.api.model.AgeGroup
import com.kok1337.feature_ppn_taxation.internal.presentation.adapter.ListItem
import com.kok1337.tax_layer.api.model.TaxLayer

internal data class TaxLayerItem(
    val taxLayer: TaxLayer,
    val taxLayerNum: Int,
) : ListItem {
    val composition: String = taxLayer.composition
    val height: Int? = taxLayer.height
    val ageClass: Int? = taxLayer.ageClass
    val ageGroup: AgeGroup? = taxLayer.ageGroup
    val fullness: Double? = taxLayer.fullness
    val stock: Double? = taxLayer.stock
    val taxLayerSpeciesCount = taxLayer.taxLayerSpeciesList.size
}