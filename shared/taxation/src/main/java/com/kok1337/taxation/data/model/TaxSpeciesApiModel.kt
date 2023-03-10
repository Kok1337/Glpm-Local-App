package com.kok1337.taxation.data.model

import java.util.*

data class TaxSpeciesApiModel(
    val id: UUID,
    val parentId: UUID,
    val speciesId: Int? = null,
    val coeff: Int? = null,
    val age: Int? = null,
    val height: Int? = null,
    val diameter: Int? = null,
    val isMain: Boolean? = null,
    val nameShort: String,
    val isExtra: Boolean = false,
    val name: String,
    val speciesNum: Int? = null,
    val gen: Int = 1,
    val stock: Int? = null,
    val merchantabilityGroupId: Int? = null,
)