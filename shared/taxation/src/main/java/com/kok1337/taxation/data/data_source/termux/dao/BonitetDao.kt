package com.kok1337.taxation.data.data_source.termux.dao

import com.kok1337.taxation.data.data_source.termux.table.BonitetTable
import com.kok1337.taxation.data.model.BonitetApiModel
import com.kok1337.termux_database.api.DatabaseFactory
import org.ktorm.dsl.eq
import org.ktorm.entity.*
import org.ktorm.support.postgresql.ilike

class BonitetDao(
    private val databaseFactory: DatabaseFactory,
) {
    internal fun getById(id: Int?): BonitetApiModel? {
        if (id == null) return null
        val database = databaseFactory.create()
        return database.sequenceOf(BonitetTable).firstOrNull { it.id eq id }
    }

    internal fun getAllWithSearch(search: String): Iterable<BonitetApiModel> {
        val database = databaseFactory.create()
        return database.sequenceOf(BonitetTable)
            .filter { it.name ilike "%${search}%" }
            .sortedBy { it.name }
            .toList()
    }
}