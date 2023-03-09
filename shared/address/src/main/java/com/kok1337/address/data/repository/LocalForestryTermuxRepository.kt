package com.kok1337.address.data.repository

import com.kok1337.address.data.data_source.dao.LocalForestryDao
import com.kok1337.address.data.data_source.dao.LocalityDao
import com.kok1337.address.data.mapper.LocalForestryApiModelMapper
import com.kok1337.address.domain.model.LocalForestry

class LocalForestryTermuxRepository(
    private val localForestryDao: LocalForestryDao,
    private val localityDao: LocalityDao,
) {
    suspend fun findById(id: Int): LocalForestry? {
        return localForestryDao.getById(id)?.let { LocalForestryApiModelMapper.toModel(it) }
    }

    suspend fun findAllByForestryIdWithSearch(
        forestryId: Int,
        search: String
    ): Iterable<LocalForestry> {
        val ids = localityDao.getAllLocalForestryIdsByForestryId(forestryId).toList()
        return localForestryDao.getAllByIdsWithSearch(ids, search)
            .map(LocalForestryApiModelMapper::toModel)
    }
}