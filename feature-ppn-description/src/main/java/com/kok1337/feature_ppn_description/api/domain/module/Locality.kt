package com.kok1337.feature_ppn_description.api.domain.module

import java.util.*

data class Locality(
    val id: UUID,
    val federalDistrict: FederalDistrict,
    val region: Region,
    val forestry: Forestry,
    val localForestry: LocalForestry,
    val subForestry: SubForestry,
    val area: String,
)