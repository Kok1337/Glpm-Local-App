package com.kok1337.feature_ppn_description.api.data.data_source.termux.dao

import com.kok1337.feature_ppn_description.api.data.data_source.termux.DatabaseFactory
import com.kok1337.feature_ppn_description.api.data.data_source.termux.table.RegionsTable
import com.kok1337.feature_ppn_description.api.data.model.RegionApiModel
import org.ktorm.dsl.eq
import org.ktorm.dsl.inList
import org.ktorm.entity.filter
import org.ktorm.entity.firstOrNull
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toList
import org.ktorm.support.postgresql.ilike
import javax.inject.Inject

internal class RegionDao @Inject constructor(
    private val databaseFactory: DatabaseFactory,
) {
    fun getAll(): Iterable<RegionApiModel> {
        return databaseFactory.create().sequenceOf(RegionsTable).toList()
    }

    fun getById(id: Int?): RegionApiModel? {
        if (id == null) return null
        return databaseFactory.create().sequenceOf(RegionsTable)
            .filter { it.id eq id }
            .firstOrNull()
    }

    fun getAllByIdsWithSearch(ids: List<Int>, search: String): Iterable<RegionApiModel> {
        return databaseFactory.create().sequenceOf(RegionsTable)
            .filter { it.id inList ids }
            .filter { it.name ilike "%${search}%" }
            .toList()
    }
}