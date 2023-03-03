package com.kok1337.feature_ppn_description.internal.data.data_source.termux.dao

import com.kok1337.feature_ppn_description.api.DatabaseFactory
import com.kok1337.feature_ppn_description.api.data.model.LocalForestryApiModel
import com.kok1337.feature_ppn_description.internal.data.data_source.termux.table.LocalForestries
import org.ktorm.dsl.eq
import org.ktorm.entity.filter
import org.ktorm.entity.firstOrNull
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toList
import javax.inject.Inject

internal class LocalForestryDao @Inject constructor(
    private val databaseFactory: DatabaseFactory,
) {
    fun getAll(): Iterable<LocalForestryApiModel> {
        return databaseFactory.create().sequenceOf(LocalForestries).toList()
    }

    fun getById(id: Int?): LocalForestryApiModel? {
        if (id == null) return null
        return databaseFactory.create().sequenceOf(LocalForestries)
            .filter { it.id eq id }
            .firstOrNull()
    }
}