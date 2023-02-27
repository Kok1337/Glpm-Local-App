package com.kok1337.feature_ppn_taxation.internal.presentation.adapter.listener

import com.kok1337.bonitet.api.model.Bonitet
import com.kok1337.forest_purpose.api.model.ForestPurpose
import com.kok1337.land.api.model.Land
import com.kok1337.non_forest_land.api.model.NonForestLand
import com.kok1337.ozu.api.model.Ozu
import com.kok1337.protection_category.api.model.ProtectionCategory
import com.kok1337.tax.api.model.Tax
import com.kok1337.unforested_land.api.model.UnforestedLand

internal interface TaxListener {
    fun onNotCoveredForestClick(isCovered: Boolean)
    fun onLandClick(land: Land?)
    fun onUnforestedLandClick(tax: Tax)
    fun onNonForestLandClick(tax: Tax)
    fun onForestPurposeClick(tax: Tax)
    fun onProtectionCategoryClick(tax: Tax)
    fun onBonitetClick(tax: Tax)
    fun onForestTypeClick(tax: Tax)
    fun onOzuClick(tax: Tax)

//    fun onNotCoveredForestClick(isCovered: Boolean)
//    fun onLandClick(land: Land?)
//    fun onUnforestedLandClick(unforestedLand: UnforestedLand?)
//    fun onNonForestLandClick(nonForestLand: NonForestLand?)
//    fun onForestPurposeClick(forestPurpose: ForestPurpose?)
//    fun onProtectionCategoryClick(protectionCategory: ProtectionCategory?)
//    fun onBonitetClick(bonitet: Bonitet?)
//    fun onForestTypeClick(forestType: String?)
//    fun onOzuClick(ozu: Ozu?)
}