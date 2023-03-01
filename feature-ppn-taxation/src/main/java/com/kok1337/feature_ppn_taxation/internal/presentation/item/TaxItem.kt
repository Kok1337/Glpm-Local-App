package com.kok1337.feature_ppn_taxation.internal.presentation.item

import com.kok1337.bonitet.api.model.Bonitet
import com.kok1337.feature_ppn_taxation.internal.presentation.adapter.listitem_adapter.ListItem
import com.kok1337.forest_purpose.api.model.ForestPurpose
import com.kok1337.land.api.model.Land
import com.kok1337.non_forest_land.api.model.NonForestLand
import com.kok1337.ozu.api.model.Ozu
import com.kok1337.protection_category.api.model.ProtectionCategory
import com.kok1337.tax.api.model.Tax
import com.kok1337.unforested_land.api.model.UnforestedLand
import java.util.UUID

internal data class TaxItem(
    val taxId: UUID,
    val isCoveredForest: Boolean,
    val land: Land?,

    val nonForestLand: NonForestLand?,
    val unforestedLand: UnforestedLand?,
    val forestPurpose: ForestPurpose?,
    val protectionCategory: ProtectionCategory?,
    val bonitet: Bonitet?,
    val forestType: String?,
    val ozu: Ozu?,
) : ListItem