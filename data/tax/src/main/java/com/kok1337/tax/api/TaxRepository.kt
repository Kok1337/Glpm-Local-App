package com.kok1337.tax.api

import java.util.UUID

interface TaxRepository {
    suspend fun findById(id: UUID): TaxApiModel
}