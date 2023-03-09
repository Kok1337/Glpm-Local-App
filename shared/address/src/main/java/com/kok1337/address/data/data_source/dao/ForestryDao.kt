package com.kok1337.address.data.data_source.dao

import com.kok1337.address.data.data_source.table.ForestriesTable
import com.kok1337.address.data.model.ForestryApiModel
import com.kok1337.termux_database.api.DatabaseFactory
import org.ktorm.dsl.eq
import org.ktorm.dsl.inList
import org.ktorm.entity.filter
import org.ktorm.entity.firstOrNull
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toList
import org.ktorm.support.postgresql.ilike

class ForestryDao(
    private val databaseFactory: DatabaseFactory,
) {
    internal fun getAll(): Iterable<ForestryApiModel> {
        return databaseFactory.create().sequenceOf(ForestriesTable).toList()
    }

    internal fun getById(id: Int?): ForestryApiModel? {
        if (id == null) return null
        return databaseFactory.create().sequenceOf(ForestriesTable)
            .filter { it.id eq id }
            .firstOrNull()
    }

    internal fun getAllByIdsWithSearch(ids: List<Int>, search: String): Iterable<ForestryApiModel> {
        return databaseFactory.create().sequenceOf(ForestriesTable)
            .filter { it.id inList ids }
            .filter { it.name ilike "%${search}%" }
            .toList()
    }
}