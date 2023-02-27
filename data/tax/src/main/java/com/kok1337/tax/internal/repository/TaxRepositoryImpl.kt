package com.kok1337.tax.internal.repository

import com.kok1337.tax.api.TaxApiModel
import com.kok1337.tax.api.TaxRepository
import com.kok1337.tax.internal.datasource.database.dao.TaxDao
import java.util.*

internal class TaxRepositoryImpl constructor(
    private val taxDao: TaxDao,
) : TaxRepository {
    override suspend fun findById(id: UUID): TaxApiModel =
        taxDao.getById(id)
}