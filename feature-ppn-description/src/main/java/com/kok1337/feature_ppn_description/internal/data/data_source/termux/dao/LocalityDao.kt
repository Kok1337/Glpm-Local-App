package com.kok1337.feature_ppn_description.internal.data.data_source.termux.dao

import com.kok1337.feature_ppn_description.api.DatabaseFactory
import com.kok1337.feature_ppn_description.api.data.model.FederalDistrictApiModel
import com.kok1337.feature_ppn_description.api.data.model.ForestryApiModel
import com.kok1337.feature_ppn_description.api.data.model.LocalityApiModel
import com.kok1337.feature_ppn_description.api.data.model.RegionApiModel
import com.kok1337.feature_ppn_description.internal.data.data_source.termux.table.FederalDistricts
import com.kok1337.feature_ppn_description.internal.data.data_source.termux.table.Forestries
import com.kok1337.feature_ppn_description.internal.data.data_source.termux.table.Locality
import com.kok1337.feature_ppn_description.internal.data.data_source.termux.table.Regions
import org.ktorm.dsl.*
import org.ktorm.entity.firstOrNull
import org.ktorm.entity.sequenceOf
import org.ktorm.support.postgresql.ilike
import java.util.*
import javax.inject.Inject

class LocalityDao @Inject constructor(
    private val databaseFactory: DatabaseFactory,
) {
    fun getById(id: UUID): LocalityApiModel? {
        return databaseFactory.create().sequenceOf(Locality).firstOrNull { it.id eq id }
    }

    fun getAllFederalDistrictWithSearch(search: String): Iterable<FederalDistrictApiModel> {
        return databaseFactory.create().from(Locality)
            .leftJoin(FederalDistricts, on = Locality.federalDistrictId eq FederalDistricts.id)
            .selectDistinct()
            .where { FederalDistricts.name ilike "%${search}%" }
            .map { row -> FederalDistricts.createEntity(row) }
    }

    fun getAllRegionByFederalDistrictIdWithSearch(
        federalDistrictId: Int,
        search: String,
    ): Iterable<RegionApiModel> {
        return databaseFactory.create().from(Locality)
            .leftJoin(Regions, on = Locality.regionId eq Regions.id)
            .selectDistinct()
            .where { Locality.federalDistrictId eq federalDistrictId }
            .where { Regions.name ilike "%${search}%" }
            .map { row -> Regions.createEntity(row) }
    }

    fun getAllForestryByRegionIdWithSearch(
        regionId: Int,
        search: String,
    ): Iterable<ForestryApiModel> {
        return databaseFactory.create().from(Locality)
            .leftJoin(Forestries, on = Locality.forestryId eq Forestries.id)
            .selectDistinct()
            .where { Locality.regionId eq regionId }
            .where { Forestries.name ilike "%${search}%" }
            .map { row -> Forestries.createEntity(row) }
    }


//
//    fun findAllLocalForestryByForestryIdWithSearch(
//        forestryId: Int,
//        search: String,
//    ): Iterable<LocalForestryApiModel>
//
//    fun findAllSubForestryByLocalForestryId(
//        localForestryId: Int,
//        search: String,
//    ): Iterable<SubForestryApiModel>
//
//    fun findLocalityByLocalityFields(
//        federalDistrictId: Int,
//        regionId: Int,
//        forestryId: Int,
//        localForestryId: Int,
//        subForestryId: Int?,
//        area: String,
//    ): LocalityApiModel?
}