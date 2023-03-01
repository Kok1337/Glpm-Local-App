package com.kok1337.address.api.model

import java.util.UUID

data class Locality(
    val id: UUID,
    val district: District,
    val region: Region,
    val forestry: Forestry,
    val localForestry: LocalForestry,
    val subForestry: SubForestry,
    val area: String,
)