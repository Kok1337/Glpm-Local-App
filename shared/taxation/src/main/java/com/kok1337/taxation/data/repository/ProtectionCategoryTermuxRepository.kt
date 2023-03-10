package com.kok1337.taxation.data.repository

import com.kok1337.taxation.data.data_source.termux.dao.ProtectionCategoryDao
import com.kok1337.taxation.data.mapper.ProtectionCategoryApiModelMapper
import com.kok1337.taxation.domain.model.ProtectionCategory

class ProtectionCategoryTermuxRepository(
    private val protectionCategoryDao: ProtectionCategoryDao,
) {
    suspend fun findById(id: Int?): ProtectionCategory? {
        return protectionCategoryDao.getById(id)
            ?.let { ProtectionCategoryApiModelMapper.toModel(it) }
    }

    suspend fun findAllWithSearch(search: String): Iterable<ProtectionCategory> {
        return protectionCategoryDao.getAllWithSearch(search)
            .map(ProtectionCategoryApiModelMapper::toModel)
    }
}