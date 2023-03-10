package com.kok1337.taxation.data.repository

import com.kok1337.taxation.data.data_source.termux.dao.ForestPurposeDao
import com.kok1337.taxation.data.mapper.ForestPurposeApiModelMapper
import com.kok1337.taxation.domain.model.ForestPurpose

class ForestPurposeTermuxRepository(
    private val forestPurposeDao: ForestPurposeDao,
) {
    suspend fun findById(id: Int?): ForestPurpose? {
        return forestPurposeDao.getById(id)?.let { ForestPurposeApiModelMapper.toModel(it) }
    }

    suspend fun findAllWithSearch(search: String): Iterable<ForestPurpose> {
        return forestPurposeDao.getAllWithSearch(search).map(ForestPurposeApiModelMapper::toModel)
    }
}