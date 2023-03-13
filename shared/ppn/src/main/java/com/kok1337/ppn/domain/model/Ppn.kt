package com.kok1337.ppn.domain.model

import java.util.UUID

data class Ppn(
    val id: UUID,
    val parentId: UUID,
    val number: Int?,
    val radius: Double?,
    val district: String?,
    val note: String?,
    val some_field_for_statistic: Boolean = false
)