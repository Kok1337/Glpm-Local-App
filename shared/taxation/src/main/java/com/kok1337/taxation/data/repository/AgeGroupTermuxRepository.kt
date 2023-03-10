package com.kok1337.taxation.data.repository

import com.kok1337.taxation.data.data_source.termux.dao.AgeGroupDao
import com.kok1337.taxation.data.mapper.AgeGroupApiModelMapper
import com.kok1337.taxation.domain.model.AgeGroup

class AgeGroupTermuxRepository(
    private val ageGroupDao: AgeGroupDao,
) {
    suspend fun findById(id: Int?): AgeGroup? {
        return ageGroupDao.getById(id)?.let { AgeGroupApiModelMapper.toModel(it) }
    }

    suspend fun findAllWithSearch(search: String): Iterable<AgeGroup> {
        return ageGroupDao.getAllWithSearch(search).map(AgeGroupApiModelMapper::toModel)
    }
}