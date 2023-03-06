package com.kok1337.feature_ppn_description.api.domain.module

data class Address(
    val federalDistrict: FederalDistrict? = null,
    val region: Region? = null,
    val forestry: Forestry? = null,
    val localForestry: LocalForestry? = null,
    val subForestry: SubForestry? = null,
    val area: String? = null,
)