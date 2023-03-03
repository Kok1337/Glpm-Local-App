package com.kok1337.feature_ppn_description.api.data.repository

import com.kok1337.feature_ppn_description.api.data.model.*
import java.util.*

interface LocalityRepository {
    suspend fun findById(
        id: UUID
    ): LocalityApiModel?

    suspend fun findAllFederalDistrictWithSearch(
        search: String,
    ): Iterable<FederalDistrictApiModel>

    suspend fun findAllRegionByFederalDistrictIdWithSearch(
        federalDistrictId: Int,
        search: String,
    ): Iterable<RegionApiModel>

    suspend fun findAllForestryByRegionIdWithSearch(
        regionId: Int,
        search: String,
    ): Iterable<ForestryApiModel>

    suspend fun findAllLocalForestryByForestryIdWithSearch(
        forestryId: Int,
        search: String,
    ): Iterable<LocalForestryApiModel>

    suspend fun findAllSubForestryByLocalForestryId(
        localForestryId: Int,
        search: String,
    ): Iterable<SubForestryApiModel>

    suspend fun findLocalityByLocalityFields(
        federalDistrictId: Int,
        regionId: Int,
        forestryId: Int,
        localForestryId: Int,
        subForestryId: Int?,
        area: String,
    ): LocalityApiModel?
}