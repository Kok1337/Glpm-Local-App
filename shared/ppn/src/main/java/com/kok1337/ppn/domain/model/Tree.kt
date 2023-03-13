package com.kok1337.ppn.domain.model

import com.kok1337.species.domain.model.Species
import java.util.UUID

data class Tree(
    val id: UUID,
    val ppnId: UUID,
    val species: Species? = null,
    val diameter: Int? = null,
    val stateCategory: StateCategory? = null,
    val stateCategoryYear: Int? = null,
    val isModel: Boolean = false,
    val height: Int? = null,
    val noteToTree: String? = null,
)