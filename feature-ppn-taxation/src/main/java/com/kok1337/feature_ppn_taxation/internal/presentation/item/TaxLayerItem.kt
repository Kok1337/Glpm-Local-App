package com.kok1337.feature_ppn_taxation.internal.presentation.item

import com.kok1337.age_group.api.model.AgeGroup
import com.kok1337.feature_ppn_taxation.internal.presentation.adapter.listitem_adapter.ListItem
import com.kok1337.tax_layer.api.model.TaxLayer
import java.util.UUID

internal data class TaxLayerItem(
    val taxLayerId: UUID,
    val taxLayerNum: Int,
    val composition: String,
    val height: Int?,
    val ageClass: Int?,
    val ageGroup: AgeGroup?,
    val fullness: Double?,
    val stock: Double?,
) : ListItem