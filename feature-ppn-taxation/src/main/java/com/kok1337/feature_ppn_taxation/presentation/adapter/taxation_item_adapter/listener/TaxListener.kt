package com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.listener

import com.kok1337.taxation.domain.model.*

internal interface TaxListener {
    fun onNotCoveredForestClick(isCovered: Boolean)
    fun onLandClick(land: Land?)
    fun onUnforestedLandClick(unforestedLand: UnforestedLand?)
    fun onNonForestLandClick(nonForestLand: NonForestLand?)
    fun onForestPurposeClick(forestPurpose: ForestPurpose?)
    fun onProtectionCategoryClick(protectionCategory: ProtectionCategory?)
    fun onBonitetClick(bonitet: Bonitet?)
    fun onForestTypeClick(forestType: String?)
    fun onOzuClick(ozu: Ozu?)
}