package com.kok1337.taxation.data.data_source.termux.dao

import com.kok1337.taxation.data.data_source.termux.table.NonForestLandTable
import com.kok1337.taxation.data.model.NonForestLandApiModel
import com.kok1337.termux_database.api.DatabaseFactory
import org.ktorm.dsl.eq
import org.ktorm.entity.*
import org.ktorm.support.postgresql.ilike

class NonForestLandDao(
    private val databaseFactory: DatabaseFactory,
) {
    internal fun getById(id: Int?): NonForestLandApiModel? {
        if (id == null) return null
        val database = databaseFactory.create()
        return database.sequenceOf(NonForestLandTable).firstOrNull { it.id eq id }
    }

    internal fun getAllWithSearch(search: String): Iterable<NonForestLandApiModel> {
        val database = databaseFactory.create()
        return database.sequenceOf(NonForestLandTable)
            .filter { it.name ilike "%${search}%" }
            .sortedBy { it.name }
            .toList()
    }
}