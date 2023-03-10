package com.kok1337.taxation.data.repository

import com.kok1337.taxation.data.data_source.termux.dao.TaxSourceDao
import com.kok1337.taxation.data.mapper.TaxSourceApiModelMapper
import com.kok1337.taxation.domain.model.TaxSource

class TaxSourceTermuxRepository(
    private val taxSourceDao: TaxSourceDao,
) {
    suspend fun findById(id: Int?): TaxSource? {
        return taxSourceDao.getById(id)?.let { TaxSourceApiModelMapper.toModel(it) }
    }

    suspend fun findAllWithSearch(search: String): Iterable<TaxSource> {
        return taxSourceDao.getAllWithSearch(search).map(TaxSourceApiModelMapper::toModel)
    }
}