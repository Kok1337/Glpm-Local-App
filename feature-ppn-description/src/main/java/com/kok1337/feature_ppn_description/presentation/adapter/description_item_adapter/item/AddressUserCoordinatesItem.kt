package com.kok1337.feature_ppn_description.presentation.adapter.description_item_adapter.item

import com.kok1337.address.domain.model.*
import com.kok1337.feature_ppn_description.presentation.adapter.description_item_adapter.DescriptionItem

internal data class AddressUserCoordinatesItem(
    val federalDistrict: FederalDistrict?,
    val region: Region?,
    val forestry: Forestry?,
    val localForestry: LocalForestry?,
    val subForestry: SubForestry?,
    val area: String?,
    val isFullLocality: Boolean,
    val section: String?,
    val s: Double?
) : DescriptionItem