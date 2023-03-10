package com.kok1337.address.data.repository

import com.kok1337.address.data.data_source.termux.dao.LocalityDao
import com.kok1337.address.domain.model.Locality
import java.util.*

class LocalityTermuxRepository(
    private val localityDao: LocalityDao,
    private val federalDistrictTermuxRepository: FederalDistrictTermuxRepository,
    private val regionTermuxRepository: RegionTermuxRepository,
    private val forestryTermuxRepository: ForestryTermuxRepository,
    private val localForestryTermuxRepository: LocalForestryTermuxRepository,
    private val subForestryTermuxRepository: SubForestryTermuxRepository,
) {
    suspend fun findById(id: UUID): Locality? {
        throw Error()
    }

    suspend fun findLocalityByLocalityFields(
        federalDistrictId: Int,
        regionId: Int,
        forestryId: Int,
        localForestryId: Int,
        subForestryId: Int?,
        area: String,
    ): Locality? {
        val localityApiModel = localityDao.findLocalityByLocalityFields(
            federalDistrictId,
            regionId,
            forestryId,
            localForestryId,
            subForestryId,
            area
        ) ?: return null
        val federalDistrict =
            federalDistrictTermuxRepository.findById(federalDistrictId)!!
        val region = regionTermuxRepository.findById(regionId)!!
        val forestry = forestryTermuxRepository.findById(forestryId)!!
        val localForestry = localForestryTermuxRepository.findById(localForestryId)
        val subForestry = subForestryTermuxRepository.findById(subForestryId)
        return Locality(
            id = localityApiModel.id,
            federalDistrict = federalDistrict,
            region = region,
            forestry = forestry,
            localForestry = localForestry,
            subForestry = subForestry,
            area = area
        )
    }
}