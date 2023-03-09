package com.kok1337.address.data.data_source.dao

import com.kok1337.address.data.data_source.table.LocalityTable
import com.kok1337.address.data.model.LocalityApiModel
import com.kok1337.termux_database.api.DatabaseFactory
import org.ktorm.dsl.*
import org.ktorm.entity.firstOrNull
import org.ktorm.entity.sequenceOf
import java.util.*

class LocalityDao(
    private val databaseFactory: DatabaseFactory,
) {
    private val TAG = javaClass.simpleName

    internal fun getById(id: UUID): LocalityApiModel? {
        return databaseFactory.create().sequenceOf(LocalityTable).firstOrNull { it.id eq id }
    }

    internal fun getAllFederalDistrictIds(): Iterable<Int> {
        return databaseFactory.create().from(LocalityTable)
            .selectDistinct(LocalityTable.federalDistrictId)
            .map { row -> row[LocalityTable.federalDistrictId]!! }
    }

    internal fun getAllRegionIdsByFederalDistrictId(federalDistrictId: Int): Iterable<Int> {
        return databaseFactory.create().from(LocalityTable)
            .selectDistinct(LocalityTable.regionId)
            .where { LocalityTable.federalDistrictId eq federalDistrictId }
            .map { row -> row[LocalityTable.regionId]!! }
    }

    internal fun getAllForestryIdsByRegionId(regionId: Int): Iterable<Int> {
        return databaseFactory.create().from(LocalityTable)
            .selectDistinct(LocalityTable.forestryId)
            .where { LocalityTable.regionId eq regionId }
            .map { row -> row[LocalityTable.forestryId]!! }
    }

    internal fun getAllLocalForestryIdsByForestryId(forestryId: Int): Iterable<Int> {
        return databaseFactory.create().from(LocalityTable)
            .selectDistinct(LocalityTable.localForestryId)
            .where { LocalityTable.forestryId eq forestryId }
            .map { row -> row[LocalityTable.localForestryId]!! }
    }

    fun getAllSubForestryIdsByLocalForestryId(localForestryId: Int): Iterable<Int?> {
        val query = databaseFactory.create().from(LocalityTable)
            .selectDistinct(LocalityTable.subForestryId)
            .where { LocalityTable.localForestryId eq localForestryId }
        return query.map { row -> row[LocalityTable.subForestryId] }
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