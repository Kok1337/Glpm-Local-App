package com.kok1337.feature_ppn_description.api.data.data_source.termux.dao

import com.kok1337.feature_ppn_description.api.data.data_source.termux.DatabaseFactory
import com.kok1337.feature_ppn_description.api.data.data_source.termux.table.LocalityTable
import com.kok1337.feature_ppn_description.api.data.model.LocalityApiModel
import org.ktorm.dsl.*
import org.ktorm.entity.firstOrNull
import org.ktorm.entity.sequenceOf
import java.util.*
import javax.inject.Inject

class LocalityDao @Inject constructor(
    private val databaseFactory: DatabaseFactory,
) {
    fun getById(id: UUID): LocalityApiModel? {
        return databaseFactory.create().sequenceOf(LocalityTable).firstOrNull { it.id eq id }
    }

    fun getAllFederalDistrictIds(): Iterable<Int> {
        return databaseFactory.create().from(LocalityTable)
            .selectDistinct(LocalityTable.federalDistrictId)
            .map { row -> row[LocalityTable.federalDistrictId]!! }
    }

    fun getAllRegionIdsByFederalDistrictId(federalDistrictId: Int): Iterable<Int> {
        return databaseFactory.create().from(LocalityTable)
            .selectDistinct(LocalityTable.regionId)
            .where { LocalityTable.federalDistrictId eq federalDistrictId }
            .map { row -> row[LocalityTable.regionId]!! }
    }

    fun getAllForestryIdsByRegionId(regionId: Int): Iterable<Int> {
        return databaseFactory.create().from(LocalityTable)
            .selectDistinct(LocalityTable.forestryId)
            .where { LocalityTable.regionId eq regionId }
            .map { row -> row[LocalityTable.forestryId]!! }
    }

    fun getAllLocalForestryIdsByForestryId(forestryId: Int): Iterable<Int> {
        return databaseFactory.create().from(LocalityTable)
            .selectDistinct(LocalityTable.localForestryId)
            .where { LocalityTable.forestryId eq forestryId }
            .map { row -> row[LocalityTable.localForestryId]!! }
    }

    fun getAllSubForestryIdsByLocalForestryId(localForestryId: Int): Iterable<Int> {
        return databaseFactory.create().from(LocalityTable)
            .selectDistinct(LocalityTable.subForestryId)
            .where { LocalityTable.localForestryId eq localForestryId }
            .map { row -> row[LocalityTable.subForestryId]!! }
    }


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