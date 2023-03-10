package com.kok1337.taxation.data.data_source.termux.dao

import com.kok1337.taxation.data.data_source.termux.table.ForestPurposeTable
import com.kok1337.taxation.data.model.ForestPurposeApiModel
import com.kok1337.termux_database.api.DatabaseFactory
import org.ktorm.dsl.eq
import org.ktorm.entity.*
import org.ktorm.support.postgresql.ilike

class ForestPurposeDao(
    private val databaseFactory: DatabaseFactory,
) {
    internal fun getById(id: Int?): ForestPurposeApiModel? {
        if (id == null) return null
        val database = databaseFactory.create()
        return database.sequenceOf(ForestPurposeTable).firstOrNull { it.id eq id }
    }

    internal fun getAllWithSearch(search: String): Iterable<ForestPurposeApiModel> {
        val database = databaseFactory.create()
        return database.sequenceOf(ForestPurposeTable)
            .filter { it.name ilike "%${search}%" }
            .sortedBy { it.name }
            .toList()
    }
}