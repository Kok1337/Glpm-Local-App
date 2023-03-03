package com.kok1337.feature_ppn_description.api.data.model

import java.util.*

data class LocalityApiModel(
    val id: UUID,
    val federalDistrictId: Int,
    val regionId: Int,
    val forestryId: Int,
    val localForestryId: Int,
    val subForestryId: Int?,
    val area: String
)