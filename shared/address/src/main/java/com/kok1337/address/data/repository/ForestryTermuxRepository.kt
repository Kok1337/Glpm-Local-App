package com.kok1337.address.data.repository

import com.kok1337.address.data.data_source.termux.dao.ForestryDao
import com.kok1337.address.data.data_source.termux.dao.LocalityDao
import com.kok1337.address.data.mapper.ForestryApiModelMapper
import com.kok1337.address.domain.model.Forestry

class ForestryTermuxRepository(
    private val forestryDao: ForestryDao,
    private val localityDao: LocalityDao,
) {
    suspend fun findById(id: Int): Forestry? {
        return forestryDao.getById(id)
            ?.let { ForestryApiModelMapper.toModel(it) }
    }

    suspend fun findAllByRegionIdWithSearch(regionId: Int, search: String): Iterable<Forestry> {
        val ids = localityDao.getAllForestryIdsByRegionId(regionId).toList()
        return forestryDao.getAllByIdsWithSearch(ids, search)
            .map(ForestryApiModelMapper::toModel)
    }
}