package com.kok1337.taxation.domain.model

import com.kok1337.species.domain.model.Species
import java.util.*

data class TaxSpecies(
    val id: UUID,
    val parentId: UUID,
    val species: Species? = null,
    val coeff: Int? = null,
    val age: Int? = null,
    val height: Int? = null,
    val diameter: Int? = null,
) {
    val isExtra: Boolean = coeff == null || coeff == 0
}