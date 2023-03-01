package com.kok1337.address.api.repository

import com.kok1337.address.api.model.*
import java.util.UUID

interface AddressRepository {
    suspend fun findDistrictById(id: Int): District

    suspend fun findRegionById(id: Int): Region

    suspend fun findForestryById(id: Int): Forestry

    suspend fun findLocalForestryById(id: Int): LocalForestry

    suspend fun findSubForestryById(id: Int): SubForestry

    suspend fun findAllDistrictWithSearch(
        search: String
    ): List<District>

    suspend fun findAllRegionByDistrictWithSearch(
        district: District, search: String
    ): List<Region>

    suspend fun findAllForestryByRegionWithSearch(
        region: Region, search: String
    ): List<Forestry>

    suspend fun findAllLocalForestryByForestryWithSearch(
        forestry: Forestry, search: String
    ): List<LocalForestry>

    suspend fun findAllSubForestryByLocalForestryWithSearch(
        localForestry: LocalForestry, search: String
    ): List<SubForestry>

    suspend fun findLocalityByAddress(address: Address): Locality

    suspend fun fundLocalityById(id: UUID): Locality
}