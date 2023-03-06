package com.kok1337.feature_ppn_description.api.data.repository

import com.kok1337.feature_ppn_description.api.data.data_source.termux.dao.LocalForestryDao
import com.kok1337.feature_ppn_description.api.data.data_source.termux.dao.LocalityDao
import com.kok1337.feature_ppn_description.api.data.mapper.LocalForestryApiModelMapper
import com.kok1337.feature_ppn_description.api.domain.module.LocalForestry
import javax.inject.Inject

internal class LocalForestryTermuxRepository @Inject constructor(
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