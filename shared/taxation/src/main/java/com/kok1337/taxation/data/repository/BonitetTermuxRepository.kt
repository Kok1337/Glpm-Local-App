package com.kok1337.taxation.data.repository

import com.kok1337.taxation.data.data_source.termux.dao.BonitetDao
import com.kok1337.taxation.data.mapper.BonitetApiModelMapper
import com.kok1337.taxation.domain.model.Bonitet

class BonitetTermuxRepository(
    private val bonitetDao: BonitetDao,
) {
    suspend fun findById(id: Int?): Bonitet? {
        return bonitetDao.getById(id)?.let { BonitetApiModelMapper.toModel(it) }
    }

    suspend fun findAllWithSearch(search: String): Iterable<Bonitet> {
        return bonitetDao.getAllWithSearch(search).map(BonitetApiModelMapper::toModel)
    }
}