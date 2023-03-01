package com.kok1337.address.api.model

data class Address(
    val district: District?,
    val region: Region?,
    val forestry: Forestry?,
    val localForestry: LocalForestry?,
    val subForestry: SubForestry?,
    val area: String?,
)