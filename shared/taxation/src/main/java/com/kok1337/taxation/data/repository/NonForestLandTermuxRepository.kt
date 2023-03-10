package com.kok1337.taxation.data.repository

import com.kok1337.taxation.data.data_source.termux.dao.NonForestLandDao
import com.kok1337.taxation.data.mapper.NonForestLandApiModelMapper
import com.kok1337.taxation.domain.model.NonForestLand

class NonForestLandTermuxRepository(
    private val nonForestLandDao: NonForestLandDao,
) {
    suspend fun findById(id: Int?): NonForestLand? {
        return nonForestLandDao.getById(id)?.let { NonForestLandApiModelMapper.toModel(it) }
    }

    suspend fun findAllWithSearch(search: String): Iterable<NonForestLand> {
        return nonForestLandDao.getAllWithSearch(search).map(NonForestLandApiModelMapper::toModel)
    }
}