package com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.item

import com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.TaxationItem
import com.kok1337.taxation.domain.model.*
import java.util.*

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
) : TaxationItem