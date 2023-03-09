package com.kok1337.address.data.model

import java.util.*

internal data class LocalityApiModel(
    val id: UUID,
    val federalDistrictId: Int,
    val regionId: Int,
    val forestryId: Int,
    val localForestryId: Int,
    val subForestryId: Int?,
    val area: String
)