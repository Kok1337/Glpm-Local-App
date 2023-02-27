package com.kok1337.tax.api.model

import com.kok1337.bonitet.api.model.Bonitet
import com.kok1337.forest_purpose.api.model.ForestPurpose
import com.kok1337.non_forest_land.api.model.NonForestLand
import com.kok1337.ozu.api.model.Ozu
import com.kok1337.protection_category.api.model.ProtectionCategory
import com.kok1337.tax_layer.api.model.TaxLayer
import com.kok1337.unforested_land.api.model.UnforestedLand
import java.sql.Date
import java.util.*

data class Tax(
    val id: UUID,
    val localityId: UUID,
    val section: String,

    val taxLayerList: List<TaxLayer>,

    val forestPurpose: ForestPurpose? = null,
    val protectionCategory: ProtectionCategory? = null,
    val ozu: Ozu? = null,
    val nonForestLand: NonForestLand? = null,
    val unforestedLand: UnforestedLand? = null,
    val bonitet: Bonitet? = null,

    val ooptId: Int? = null,
    val isWaterProtectionZone: Boolean? = false,
    val tenant: String? = null,
    val leaseContractNum: String? = null,
    val leaseContractDate: Date? = null,
    val leaseTypeId: Int? = null,
    val cadastralNum: String? = null,
    val firePrescription: Int? = null,
    val forestUseId: Int? = null,
    val s: Double? = null,
    val forestInventoryYear: Int? = null,
    val forestType: String? = null,
    val tluId: Int? = null,
    val landCatId: Int? = null,
    val underwood: String? = null,
    val isNatural: Boolean? = null,
    val leaseContractTypeId: Int? = null,
    val forestZoneId: Int? = null,
    val isArtificial: Boolean? = null,
    val plantingYear: Int? = null,
    val isAfterTapping: Boolean? = null,
    val tabZoneId: Int? = null,
    val tlu: String? = null,
    val isDrained: Boolean? = null,
    val ageGroupId: Int? = null,
    val isFireBurned: Boolean? = null,
    val radioactiveZoneId: Int? = null,
    val stockDead: Double? = null,
    val stockOpenStand: Double? = null,
    val stockSingleTree: Double? = null,
    val stockFellingDebris: Double? = null,
    val stockLiquidDebris: Double? = null,
    val isDraft: Boolean = true,
    val dataSourceId: Int? = null,
    val isNewDead: Boolean? = null,
    val oopt: String? = null,
//    val ozu: String? = null,
    val forestUse: String? = null,
    val stockSection: Double? = null,
)