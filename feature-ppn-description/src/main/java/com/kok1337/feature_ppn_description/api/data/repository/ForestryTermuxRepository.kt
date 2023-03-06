package com.kok1337.feature_ppn_description.api.data.repository

import com.kok1337.feature_ppn_description.api.data.data_source.termux.dao.ForestryDao
import com.kok1337.feature_ppn_description.api.data.data_source.termux.dao.LocalityDao
import com.kok1337.feature_ppn_description.api.data.mapper.ForestryApiModelMapper
import com.kok1337.feature_ppn_description.api.domain.module.Forestry
import javax.inject.Inject

internal class ForestryTermuxRepository @Inject constructor(
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