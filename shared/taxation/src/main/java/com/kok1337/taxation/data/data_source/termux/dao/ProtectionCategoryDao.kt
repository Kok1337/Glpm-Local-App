package com.kok1337.taxation.data.data_source.termux.dao

import com.kok1337.taxation.data.data_source.termux.table.ProtectionCategoryTable
import com.kok1337.taxation.data.model.ProtectionCategoryApiModel
import com.kok1337.termux_database.api.DatabaseFactory
import org.ktorm.dsl.eq
import org.ktorm.entity.*
import org.ktorm.support.postgresql.ilike

class ProtectionCategoryDao(
    private val databaseFactory: DatabaseFactory,
) {
    internal fun getById(id: Int?): ProtectionCategoryApiModel? {
        if (id == null) return null
        val database = databaseFactory.create()
        return database.sequenceOf(ProtectionCategoryTable).firstOrNull { it.id eq id }
    }

    internal fun getAllWithSearch(search: String): Iterable<ProtectionCategoryApiModel> {
        val database = databaseFactory.create()
        return database.sequenceOf(ProtectionCategoryTable)
            .filter { it.name ilike "%${search}%" }
            .sortedBy { it.name }
            .toList()
    }
}