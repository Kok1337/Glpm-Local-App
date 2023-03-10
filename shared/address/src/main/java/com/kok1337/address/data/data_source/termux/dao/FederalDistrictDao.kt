package com.kok1337.address.data.data_source.termux.dao

import com.kok1337.address.data.data_source.termux.table.FederalDistrictTable
import com.kok1337.address.data.model.FederalDistrictApiModel
import com.kok1337.termux_database.api.DatabaseFactory
import org.ktorm.dsl.eq
import org.ktorm.dsl.inList
import org.ktorm.entity.filter
import org.ktorm.entity.firstOrNull
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toList
import org.ktorm.support.postgresql.ilike

class FederalDistrictDao(
    private val databaseFactory: DatabaseFactory,
) {
    internal fun getAll(): Iterable<FederalDistrictApiModel> {
        return databaseFactory.create().sequenceOf(FederalDistrictTable).toList()
    }

    internal fun getById(id: Int?): FederalDistrictApiModel? {
        if (id == null) return null
        val database = databaseFactory.create()
        return database.sequenceOf(FederalDistrictTable)
            .filter { it.id eq id }
            .firstOrNull()
    }

    internal fun getAllByIdsWithSearch(ids: List<Int>, search: String): Iterable<FederalDistrictApiModel> {
        return databaseFactory.create().sequenceOf(FederalDistrictTable)
            .filter { it.id inList ids }
            .filter { it.name ilike "%${search}%" }
            .toList()
    }
}