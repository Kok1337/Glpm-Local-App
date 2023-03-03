package com.kok1337.feature_ppn_description.internal.data.data_source.termux.dao

import com.kok1337.feature_ppn_description.api.DatabaseFactory
import com.kok1337.feature_ppn_description.api.data.model.RegionApiModel
import com.kok1337.feature_ppn_description.internal.data.data_source.termux.table.Regions
import org.ktorm.dsl.eq
import org.ktorm.entity.filter
import org.ktorm.entity.firstOrNull
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toList
import javax.inject.Inject

internal class RegionDao @Inject constructor(
    private val databaseFactory: DatabaseFactory,
) {
    fun getAll(): Iterable<RegionApiModel> {
        return databaseFactory.create().sequenceOf(Regions).toList()
    }

    fun getById(id: Int?): RegionApiModel? {
        if (id == null) return null
        return databaseFactory.create().sequenceOf(Regions)
            .filter { it.id eq id }
            .firstOrNull()
    }
}