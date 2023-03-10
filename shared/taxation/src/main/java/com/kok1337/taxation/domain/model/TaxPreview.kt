package com.kok1337.taxation.domain.model

import java.util.UUID

data class TaxPreview(
    val id: UUID,
    val s: Double? = null,
    val forestInventoryYear: Int? = null,
    val taxSource: TaxSource?
)