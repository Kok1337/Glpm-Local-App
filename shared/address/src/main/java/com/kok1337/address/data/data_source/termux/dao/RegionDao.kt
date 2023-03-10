package com.kok1337.address.data.data_source.termux.dao

import com.kok1337.address.data.data_source.termux.table.RegionTable
import com.kok1337.address.data.model.RegionApiModel
import com.kok1337.termux_database.api.DatabaseFactory
import org.ktorm.dsl.eq
import org.ktorm.dsl.inList
import org.ktorm.entity.filter
import org.ktorm.entity.firstOrNull
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toList
import org.ktorm.support.postgresql.ilike

class RegionDao(
    private val databaseFactory: DatabaseFactory,
) {
    internal fun getAll(): Iterable<RegionApiModel> {
        return databaseFactory.create().sequenceOf(RegionTable).toList()
    }

    internal fun getById(id: Int?): RegionApiModel? {
        if (id == null) return null
        return databaseFactory.create().sequenceOf(RegionTable)
            .filter { it.id eq id }
            .firstOrNull()
    }

    internal fun getAllByIdsWithSearch(ids: List<Int>, search: String): Iterable<RegionApiModel> {
        return databaseFactory.create().sequenceOf(RegionTable)
            .filter { it.id inList ids }
            .filter { it.name ilike "%${search}%" }
            .toList()
    }
}