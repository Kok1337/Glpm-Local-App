package com.kok1337.feature_ppn_description.api.domain.module

data class Address(
    val federalDistrict: FederalDistrict?,
    val region: Region?,
    val forestry: Forestry?,
    val localForestry: LocalForestry?,
    val subForestry: SubForestry?,
    val area: String?,
)