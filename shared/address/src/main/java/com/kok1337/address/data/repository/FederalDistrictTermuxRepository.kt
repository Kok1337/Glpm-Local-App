package com.kok1337.address.data.repository

import com.kok1337.address.data.data_source.dao.FederalDistrictDao
import com.kok1337.address.data.data_source.dao.LocalityDao
import com.kok1337.address.data.mapper.FederalDistrictApiModelMapper
import com.kok1337.address.domain.model.FederalDistrict

class FederalDistrictTermuxRepository(
    private val federalDistrictDao: FederalDistrictDao,
    private val localityDao: LocalityDao,
) {
    suspend fun findById(id: Int): FederalDistrict? {
        return federalDistrictDao.getById(id)
            ?.let { FederalDistrictApiModelMapper.toModel(it) }
    }

    suspend fun findAllWithSearch(search: String): Iterable<FederalDistrict> {
        val ids = localityDao.getAllFederalDistrictIds().toList()
        return federalDistrictDao.getAllByIdsWithSearch(ids, search)
            .map(FederalDistrictApiModelMapper::toModel)
    }
}