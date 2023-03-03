package com.kok1337.feature_ppn_description.internal.data.repository

import com.kok1337.feature_ppn_description.api.data.model.*
import com.kok1337.feature_ppn_description.api.data.repository.LocalityRepository
import com.kok1337.feature_ppn_description.internal.data.data_source.termux.dao.LocalityDao
import java.util.*
import javax.inject.Inject

internal class LocalityRepositoryImpl @Inject constructor(
    private val localityDao: LocalityDao,
) : LocalityRepository {
    override suspend fun findById(id: UUID): LocalityApiModel? {
        TODO("Not yet implemented")
    }

    override suspend fun findAllFederalDistrictWithSearch(search: String): Iterable<FederalDistrictApiModel> {
        return localityDao.getAllFederalDistrictWithSearch(search)
    }

    override suspend fun findAllRegionByFederalDistrictIdWithSearch(
        federalDistrictId: Int,
        search: String
    ): Iterable<RegionApiModel> {
        return localityDao.getAllRegionByFederalDistrictIdWithSearch(federalDistrictId, search)
    }

    override suspend fun findAllForestryByRegionIdWithSearch(
        regionId: Int,
        search: String
    ): Iterable<ForestryApiModel> {
        TODO("Not yet implemented")
    }

    override suspend fun findAllLocalForestryByForestryIdWithSearch(
        forestryId: Int,
        search: String
    ): Iterable<LocalForestryApiModel> {
        TODO("Not yet implemented")
    }

    override suspend fun findAllSubForestryByLocalForestryId(
        localForestryId: Int,
        search: String
    ): Iterable<SubForestryApiModel> {
        TODO("Not yet implemented")
    }

    override suspend fun findLocalityByLocalityFields(
        federalDistrictId: Int,
        regionId: Int,
        forestryId: Int,
        localForestryId: Int,
        subForestryId: Int?,
        area: String
    ): LocalityApiModel? {
        TODO("Not yet implemented")
    }

}