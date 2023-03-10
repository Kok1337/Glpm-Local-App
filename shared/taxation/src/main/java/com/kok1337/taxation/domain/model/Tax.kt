package com.kok1337.taxation.domain.model

import java.util.*

data class Tax(
    val id: UUID,
    val localityId: UUID,
    val taxSource: TaxSource,
    val section: String,
    val s: Double? = null,

    val taxLayerList: List<TaxLayer>,

    val nonForestLand: NonForestLand? = null,
    val unforestedLand: UnforestedLand? = null,
    val forestPurpose: ForestPurpose? = null,
    val protectionCategory: ProtectionCategory? = null,
    val bonitet: Bonitet? = null,
    val forestType: String? = null,
    val ozu: Ozu? = null,
)