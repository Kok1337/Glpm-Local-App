package com.kok1337.feature_ppn_description.api.data.repository

import com.kok1337.feature_ppn_description.api.data.data_source.termux.dao.LocalityDao
import com.kok1337.feature_ppn_description.api.data.data_source.termux.dao.SubForestryDao
import com.kok1337.feature_ppn_description.api.data.mapper.SubForestryApiModelMapper
import com.kok1337.feature_ppn_description.api.domain.module.SubForestry
import javax.inject.Inject

internal class SubForestryTermuxRepository @Inject constructor(
    private val subForestryDao: SubForestryDao,
    private val localityDao: LocalityDao,
) {
    suspend fun findById(id: Int): SubForestry? {
        return subForestryDao.getById(id)?.let { SubForestryApiModelMapper.toModel(it) }
    }

    suspend fun findAllByLocalForestryIdWithSearch(
        localForestryId: Int,
        search: String
    ): Iterable<SubForestry> {
        val ids = localityDao.getAllSubForestryIdsByLocalForestryId(localForestryId).toList()
        return subForestryDao.getAllByIdsWithSearch(ids, search)
            .map(SubForestryApiModelMapper::toModel)
    }
}