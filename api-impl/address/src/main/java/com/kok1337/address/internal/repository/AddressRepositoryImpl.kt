package com.kok1337.address.internal.repository

import com.kok1337.address.api.model.*
import com.kok1337.address.api.repository.AddressRepository
import com.kok1337.address.internal.data_source.termux.dao.*
import com.kok1337.address.internal.data_source.termux.mapper.EntityMapper
import java.util.*
import javax.inject.Inject

internal class AddressRepositoryImpl @Inject constructor(
    private val districtDao: DistrictDao,
    private val regionDao: RegionDao,
    private val forestryDao: ForestryDao,
    private val localForestryDao: LocalForestryDao,
    private val subForestryDao: SubForestryDao,
    private val localityDao: LocalityDao,
) : AddressRepository {
    override suspend fun findDistrictById(id: Int): District {
        return EntityMapper.map(districtDao.getById(id))
    }

    override suspend fun findRegionById(id: Int): Region {
        return EntityMapper.map(regionDao.getById(id))
    }

    override suspend fun findForestryById(id: Int): Forestry {
        return EntityMapper.map(forestryDao.getById(id))
    }

    override suspend fun findLocalForestryById(id: Int): LocalForestry {
        return EntityMapper.map(localForestryDao.getById(id))
    }

    override suspend fun findSubForestryById(id: Int): SubForestry {
        return EntityMapper.map(subForestryDao.getById(id))
    }

    override suspend fun findAllDistrictWithSearch(search: String): List<District> {
        val districtIdList = localityDao.getAllDistrictId()
        return districtDao.getAllByIdsWithSearch(districtIdList, search).map(EntityMapper::map)
    }

    override suspend fun findAllRegionByDistrictWithSearch(
        district: District,
        search: String
    ): List<Region> {
        val regionIdList = localityDao.getAllRegionIdByDistrictId(district.id)
        return regionDao.getAllByIdsWithSearch(regionIdList, search).map(EntityMapper::map)
    }

    override suspend fun findAllForestryByRegionWithSearch(
        region: Region,
        search: String
    ): List<Forestry> {
        val forestryIdList = localityDao.getAllRegionIdByDistrictId(region.id)
        return forestryDao.getAllByIdsWithSearch(forestryIdList, search).map(EntityMapper::map)
    }

    override suspend fun findAllLocalForestryByForestryWithSearch(
        forestry: Forestry,
        search: String
    ): List<LocalForestry> {
        val localForestryIdList = localityDao.getAllRegionIdByDistrictId(forestry.id)
        return localForestryDao.getAllByIdsWithSearch(localForestryIdList, search)
            .map(EntityMapper::map)
    }

    override suspend fun findAllSubForestryByLocalForestryWithSearch(
        localForestry: LocalForestry,
        search: String
    ): List<SubForestry> {
        val subForestryIdList = localityDao.getAllRegionIdByDistrictId(localForestry.id)
        return subForestryDao.getAllByIdsWithSearch(subForestryIdList, search)
            .map(EntityMapper::map)
    }

    override suspend fun findLocalityByAddress(address: Address): Locality {
        val localityEntity = localityDao.getByFields(EntityMapper.map(address))
        val district = findDistrictById(localityEntity.districtId!!)
        val region = findRegionById(localityEntity.regionId!!)
        val forestry = findForestryById(localityEntity.forestryId!!)
        val localForestry = findLocalForestryById(localityEntity.forestryId!!)
        val subForestry = findSubForestryById(localityEntity.subForestryId!!)
        return Locality(
            id = localityEntity.id!!,
            district = district,
            region = region,
            forestry = forestry,
            localForestry = localForestry,
            subForestry = subForestry,
            area = localityEntity.area!!,
        )
    }

    override suspend fun findLocalityById(id: UUID): Locality {
        val localityEntity = localityDao.getById(id)
        val district = findDistrictById(localityEntity.districtId!!)
        val region = findRegionById(localityEntity.regionId!!)
        val forestry = findForestryById(localityEntity.forestryId!!)
        val localForestry = findLocalForestryById(localityEntity.forestryId!!)
        val subForestry = findSubForestryById(localityEntity.subForestryId!!)
        return Locality(
            id = localityEntity.id!!,
            district = district,
            region = region,
            forestry = forestry,
            localForestry = localForestry,
            subForestry = subForestry,
            area = localityEntity.area!!,
        )
    }
}