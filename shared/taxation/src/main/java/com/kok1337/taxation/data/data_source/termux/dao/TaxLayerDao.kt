package com.kok1337.taxation.data.data_source.termux.dao

import com.kok1337.taxation.data.data_source.termux.table.TaxLayerTable
import com.kok1337.taxation.data.data_source.termux.table.TaxSpeciesTable
import com.kok1337.taxation.data.model.TaxLayerApiModel
import com.kok1337.termux_database.api.DatabaseFactory
import org.ktorm.dsl.eq
import org.ktorm.entity.filter
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.sortedBy
import org.ktorm.entity.toList
import java.util.UUID

class TaxLayerDao(
    private val databaseFactory: DatabaseFactory,
) {
    internal fun getAllByParentId(parentId: UUID): Iterable<TaxLayerApiModel> {
        val database = databaseFactory.create()
        return database.sequenceOf(TaxLayerTable)
            .filter { it.isDeleted eq false }
            .filter { it.parentId eq parentId }
            .sortedBy { it.layer }
            .toList()
    }
}