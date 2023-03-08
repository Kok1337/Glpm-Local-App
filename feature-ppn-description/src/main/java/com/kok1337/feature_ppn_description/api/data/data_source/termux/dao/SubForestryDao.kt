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
    private val TAG = javaClass.simpleName
    fun getAll(): Iterable<SubForestryApiModel> {
        return databaseFactory.create().sequenceOf(SubForestriesTable).toList()
    }

    private fun getItemWithNullId(): SubForestryApiModel = SubForestryApiModel(null, "(Нет)")

    fun getById(id: Int?): SubForestryApiModel? {
        if (id == null) return getItemWithNullId()
        return databaseFactory.create().sequenceOf(SubForestriesTable)
            .filter { it.id eq id }
            .firstOrNull()
    }

    fun getAllByIdsWithSearch(ids: List<Int?>, search: String): Iterable<SubForestryApiModel> {
        val idsWithoutNull = ids.filterNotNull()
        val nullIdsList = if (ids.contains(null)) listOf(getItemWithNullId()) else emptyList()
        val notNullIdsList = if (idsWithoutNull.isNotEmpty()) {
            databaseFactory.create().sequenceOf(SubForestriesTable)
                .filter { it.id inList idsWithoutNull }
                .filter { it.name ilike "%${search}%" }
                .toList()
        } else emptyList()
        return nullIdsList + notNullIdsList
    }
}