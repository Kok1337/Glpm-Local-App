package com.kok1337.address.data.repository

import com.kok1337.address.data.data_source.termux.dao.LocalityDao
import com.kok1337.address.data.data_source.termux.dao.RegionDao
import com.kok1337.address.data.mapper.RegionApiModelMapper
import com.kok1337.address.domain.model.Region

class RegionTermuxRepository(
    private val regionDao: RegionDao,
    private val localityDao: LocalityDao,
) {
    suspend fun findById(id: Int): Region? {
        return regionDao.getById(id)
            ?.let { RegionApiModelMapper.toModel(it) }
    }

    suspend fun findAllByFederalDistrictIdWithSearch(
        federalDistrictId: Int,
        search: String
    ): Iterable<Region> {
        val ids = localityDao.getAllRegionIdsByFederalDistrictId(federalDistrictId).toList()
        return regionDao.getAllByIdsWithSearch(ids, search).map(RegionApiModelMapper::toModel)
    }
}