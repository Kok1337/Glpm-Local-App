package com.kok1337.taxation.data.repository

import com.kok1337.taxation.data.data_source.termux.dao.UnforestedLandDao
import com.kok1337.taxation.data.mapper.UnforestedLandApiModelMapper
import com.kok1337.taxation.domain.model.UnforestedLand

class UnforestedLandTermuxRepository(
    private val unforestedLandDao: UnforestedLandDao,
) {
    suspend fun findById(id: Int?): UnforestedLand? {
        return unforestedLandDao.getById(id)?.let { UnforestedLandApiModelMapper.toModel(it) }
    }

    suspend fun findAllWithSearch(search: String): Iterable<UnforestedLand> {
        return unforestedLandDao.getAllWithSearch(search).map(UnforestedLandApiModelMapper::toModel)
    }
}