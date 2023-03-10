package com.kok1337.taxation.data.repository

import com.kok1337.taxation.data.data_source.termux.dao.OzuDao
import com.kok1337.taxation.data.mapper.OzuApiModelMapper
import com.kok1337.taxation.domain.model.Ozu

class OzuTermuxRepository(
    private val ozuDao: OzuDao,
) {
    suspend fun findById(id: Int?): Ozu? {
        return ozuDao.getById(id)?.let { OzuApiModelMapper.toModel(it) }
    }

    suspend fun findAllWithSearch(search: String): Iterable<Ozu> {
        return ozuDao.getAllWithSearch(search).map(OzuApiModelMapper::toModel)
    }
}