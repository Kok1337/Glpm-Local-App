package com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.item

import com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.TaxationItem
import com.kok1337.taxation.domain.model.AgeGroup
import java.util.*

internal data class TaxLayerItem(
    val taxLayerId: UUID,
    val taxLayerNum: Int,
    val composition: String,
    val height: Int?,
    val ageClass: Int?,
    val ageGroup: AgeGroup?,
    val fullness: Double?,
    val stock: Double?,
) : TaxationItem