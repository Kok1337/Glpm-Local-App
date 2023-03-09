package com.kok1337.address.domain.model

import java.util.*

data class Locality(
    val id: UUID? = null,
    val federalDistrict: FederalDistrict? = null,
    val region: Region? = null,
    val forestry: Forestry? = null,
    val localForestry: LocalForestry? = null,
    val subForestry: SubForestry? = null,
    val area: String? = null,
)