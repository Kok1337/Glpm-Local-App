package com.kok1337.address.data.data_source.termux.dao

import com.kok1337.address.data.data_source.termux.table.SubForestryTable
import com.kok1337.address.data.model.SubForestryApiModel
import com.kok1337.termux_database.api.DatabaseFactory
import org.ktorm.dsl.eq
import org.ktorm.dsl.inList
import org.ktorm.entity.filter
import org.ktorm.entity.firstOrNull
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toList
import org.ktorm.support.postgresql.ilike

class SubForestryDao(
    private val databaseFactory: DatabaseFactory,
) {
    private val TAG = javaClass.simpleName
    internal fun getAll(): Iterable<SubForestryApiModel> {
        return databaseFactory.create().sequenceOf(SubForestryTable).toList()
    }

    private fun getItemWithNullId(): SubForestryApiModel = SubForestryApiModel(null, "(Нет)")

    internal fun getById(id: Int?): SubForestryApiModel? {
        if (id == null) return getItemWithNullId()
        return databaseFactory.create().sequenceOf(SubForestryTable)
            .filter { it.id eq id }
            .firstOrNull()
    }

    internal fun getAllByIdsWithSearch(
        ids: List<Int?>,
        search: String
    ): Iterable<SubForestryApiModel> {
        val idsWithoutNull = ids.filterNotNull()
        val nullIdsList = if (ids.contains(null)) listOf(getItemWithNullId()) else emptyList()
        val notNullIdsList = if (idsWithoutNull.isNotEmpty()) {
            databaseFactory.create().sequenceOf(SubForestryTable)
                .filter { it.id inList idsWithoutNull }
                .filter { it.name ilike "%${search}%" }
                .toList()
        } else emptyList()
        return nullIdsList + notNullIdsList
    }
}