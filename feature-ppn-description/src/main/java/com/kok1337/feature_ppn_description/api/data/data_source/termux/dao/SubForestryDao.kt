package com.kok1337.feature_ppn_description.api.data.data_source.termux.dao

import com.kok1337.feature_ppn_description.api.data.data_source.termux.DatabaseFactory
import com.kok1337.feature_ppn_description.api.data.data_source.termux.table.SubForestriesTable
import com.kok1337.feature_ppn_description.api.data.model.SubForestryApiModel
import org.ktorm.dsl.eq
import org.ktorm.dsl.inList
import org.ktorm.entity.filter
import org.ktorm.entity.firstOrNull
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toList
import org.ktorm.support.postgresql.ilike
import javax.inject.Inject

internal class SubForestryDao @Inject constructor(
    private val databaseFactory: DatabaseFactory,
) {
    fun getAll(): Iterable<SubForestryApiModel> {
        return databaseFactory.create().sequenceOf(SubForestriesTable).toList()
    }

    fun getById(id: Int?): SubForestryApiModel? {
        if (id == null) return null
        return databaseFactory.create().sequenceOf(SubForestriesTable)
            .filter { it.id eq id }
            .firstOrNull()
    }

    fun getAllByIdsWithSearch(ids: List<Int>, search: String): Iterable<SubForestryApiModel> {
        return databaseFactory.create().sequenceOf(SubForestriesTable)
            .filter { it.id inList ids }
            .filter { it.name ilike "%${search}%" }
            .toList()
    }
}