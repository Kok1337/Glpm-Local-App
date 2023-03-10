package com.kok1337.taxation.data.data_source.termux.dao

import com.kok1337.taxation.data.data_source.termux.table.TaxSourceTable
import com.kok1337.taxation.data.model.TaxSourceApiModel
import com.kok1337.termux_database.api.DatabaseFactory
import org.ktorm.dsl.eq
import org.ktorm.entity.*
import org.ktorm.support.postgresql.ilike

class TaxSourceDao(
    private val databaseFactory: DatabaseFactory,
) {
    internal fun getById(id: Int?): TaxSourceApiModel? {
        if (id == null) return null
        val database = databaseFactory.create()
        return database.sequenceOf(TaxSourceTable).firstOrNull { it.id eq id }
    }

    internal fun getAllWithSearch(search: String): Iterable<TaxSourceApiModel> {
        val database = databaseFactory.create()
        return database.sequenceOf(TaxSourceTable)
            .filter { it.name ilike "%${search}%" }
            .sortedBy { it.name }
            .toList()
    }
}