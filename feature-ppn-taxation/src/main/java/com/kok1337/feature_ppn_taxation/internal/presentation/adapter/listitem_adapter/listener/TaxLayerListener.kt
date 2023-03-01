package com.kok1337.feature_ppn_taxation.internal.presentation.adapter.listitem_adapter.listener

import com.kok1337.age_group.api.model.AgeGroup
import java.util.*

internal interface TaxLayerListener {
    fun onTaxLayerHeightClick(taxLayerId: UUID, height: Int?)
    fun onAgeClassClick(taxLayerId: UUID, ageClass: Int?)
    fun onAgeGroupClick(taxLayerId: UUID, ageGroup: AgeGroup?)
    fun onFullnessClick(taxLayerId: UUID, fullness: Double?)
    fun onStockClick(taxLayerId: UUID, stock: Double?)
    fun onDeleteTaxLayerClick(taxLayerId: UUID)

}