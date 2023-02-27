package com.kok1337.tax_layer.api

import java.util.*

data class TaxLayerApiModel(
    val id: UUID,
    val parentId: UUID,
    val layer: Int? = null,
    val composition: String? = null,
    val fullness: Double? = null,
    val stock: Double? = null,
    val ageClass: Int? = null,
    val ageGroupId: Int? = null,
    val height: Int? = null,
    val layerTypeId: Int? = 1,
    val age: Int? = null,
    val density: Double? = null,
    val condition: String? = null,
)