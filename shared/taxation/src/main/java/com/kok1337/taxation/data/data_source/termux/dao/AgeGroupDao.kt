package com.kok1337.taxation.data.data_source.termux.dao

import com.kok1337.taxation.data.data_source.termux.table.AgeGroupTable
import com.kok1337.taxation.data.model.AgeGroupApiModel
import com.kok1337.termux_database.api.DatabaseFactory
import org.ktorm.dsl.eq
import org.ktorm.entity.*
import org.ktorm.support.postgresql.ilike

class AgeGroupDao(
    private val databaseFactory: DatabaseFactory,
) {
    internal fun getById(id: Int?): AgeGroupApiModel? {
        if (id == null) return null
        val database = databaseFactory.create()
        return database.sequenceOf(AgeGroupTable).firstOrNull { it.id eq id }
    }

    internal fun getAllWithSearch(search: String): Iterable<AgeGroupApiModel> {
        val database = databaseFactory.create()
        return database.sequenceOf(AgeGroupTable)
            .filter { it.name ilike "%${search}%" }
            .sortedBy { it.name }
            .toList()
    }
}