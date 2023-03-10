package com.kok1337.address.data.repository

import com.kok1337.address.data.data_source.termux.dao.LocalityDao
import com.kok1337.address.data.data_source.termux.dao.SubForestryDao
import com.kok1337.address.data.mapper.SubForestryApiModelMapper
import com.kok1337.address.domain.model.SubForestry

class SubForestryTermuxRepository(
    private val subForestryDao: SubForestryDao,
    private val localityDao: LocalityDao,
) {
    suspend fun findById(id: Int?): SubForestry? {
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