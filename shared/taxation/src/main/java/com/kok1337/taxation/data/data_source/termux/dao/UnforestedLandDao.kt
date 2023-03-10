package com.kok1337.taxation.data.data_source.termux.dao

import com.kok1337.taxation.data.data_source.termux.table.UnforestedLandTable
import com.kok1337.taxation.data.model.UnforestedLandApiModel
import com.kok1337.termux_database.api.DatabaseFactory
import org.ktorm.dsl.eq
import org.ktorm.entity.*
import org.ktorm.support.postgresql.ilike

class UnforestedLandDao(
    private val databaseFactory: DatabaseFactory,
) {
    internal fun getById(id: Int?): UnforestedLandApiModel? {
        if (id == null) return null
        val database = databaseFactory.create()
        return database.sequenceOf(UnforestedLandTable).firstOrNull { it.id eq id }
    }

    internal fun getAllWithSearch(search: String): Iterable<UnforestedLandApiModel> {
        val database = databaseFactory.create()
        return database.sequenceOf(UnforestedLandTable)
            .filter { it.name ilike "%${search}%" }
            .sortedBy { it.name }
            .toList()
    }
}