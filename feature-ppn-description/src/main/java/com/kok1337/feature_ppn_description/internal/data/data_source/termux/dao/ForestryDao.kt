package com.kok1337.feature_ppn_description.internal.data.data_source.termux.dao

import com.kok1337.feature_ppn_description.api.DatabaseFactory
import com.kok1337.feature_ppn_description.api.data.model.ForestryApiModel
import com.kok1337.feature_ppn_description.internal.data.data_source.termux.table.Forestries
import org.ktorm.dsl.eq
import org.ktorm.entity.filter
import org.ktorm.entity.firstOrNull
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toList
import javax.inject.Inject

internal class ForestryDao @Inject constructor(
    private val databaseFactory: DatabaseFactory,
) {
    fun getAll(): Iterable<ForestryApiModel> {
        return databaseFactory.create().sequenceOf(Forestries).toList()
    }

    fun getById(id: Int?): ForestryApiModel? {
        if (id == null) return null
        return databaseFactory.create().sequenceOf(Forestries)
            .filter { it.id eq id }
            .firstOrNull()
    }
}