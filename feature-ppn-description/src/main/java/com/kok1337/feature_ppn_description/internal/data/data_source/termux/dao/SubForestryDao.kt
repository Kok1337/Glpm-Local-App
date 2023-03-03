package com.kok1337.feature_ppn_description.internal.data.data_source.termux.dao

import com.kok1337.feature_ppn_description.api.DatabaseFactory
import com.kok1337.feature_ppn_description.api.data.model.SubForestryApiModel
import com.kok1337.feature_ppn_description.internal.data.data_source.termux.table.SubForestries
import org.ktorm.dsl.eq
import org.ktorm.entity.filter
import org.ktorm.entity.firstOrNull
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toList
import javax.inject.Inject

internal class SubForestryDao @Inject constructor(
    private val databaseFactory: DatabaseFactory,
) {
    fun getAll(): Iterable<SubForestryApiModel> {
        return databaseFactory.create().sequenceOf(SubForestries).toList()
    }

    fun getById(id: Int?): SubForestryApiModel? {
        if (id == null) return null
        return databaseFactory.create().sequenceOf(SubForestries)
            .filter { it.id eq id }
            .firstOrNull()
    }
}