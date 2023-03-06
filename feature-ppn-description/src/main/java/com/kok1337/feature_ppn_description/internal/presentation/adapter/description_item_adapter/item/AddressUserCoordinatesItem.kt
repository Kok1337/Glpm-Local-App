package com.kok1337.feature_ppn_description.internal.presentation.adapter.description_item_adapter.item

import com.kok1337.feature_ppn_description.api.domain.module.*
import com.kok1337.feature_ppn_description.internal.presentation.adapter.description_item_adapter.DescriptionItem

internal data class AddressUserCoordinatesItem(
    val federalDistrict: FederalDistrict?,
    val region: Region?,
    val forestry: Forestry?,
    val localForestry: LocalForestry?,
    val subForestry: SubForestry?,
    val area: String?,
) : DescriptionItem