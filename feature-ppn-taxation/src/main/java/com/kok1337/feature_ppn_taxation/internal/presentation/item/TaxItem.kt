package com.kok1337.feature_ppn_taxation.internal.presentation.item

import com.kok1337.bonitet.api.model.Bonitet
import com.kok1337.feature_ppn_taxation.internal.presentation.adapter.ListItem
import com.kok1337.forest_purpose.api.model.ForestPurpose
import com.kok1337.land.api.model.Land
import com.kok1337.non_forest_land.api.model.NonForestLand
import com.kok1337.ozu.api.model.Ozu
import com.kok1337.protection_category.api.model.ProtectionCategory
import com.kok1337.tax.api.model.Tax
import com.kok1337.unforested_land.api.model.UnforestedLand

internal data class TaxItem(
    val tax: Tax,
    val isCoveredForest: Boolean,
    val land: Land?,
) : ListItem {
    val nonForestLand: NonForestLand? = tax.nonForestLand
    val unforestedLand: UnforestedLand? = tax.unforestedLand
    val forestPurpose: ForestPurpose? = tax.forestPurpose
    val protectionCategory: ProtectionCategory? = tax.protectionCategory
    val bonitet: Bonitet? = tax.bonitet
    val forestType: String? = tax.forestType
    val ozu: Ozu? = tax.ozu
}