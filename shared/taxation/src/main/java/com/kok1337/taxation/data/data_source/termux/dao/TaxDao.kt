package com.kok1337.taxation.data.data_source.termux.dao

import com.kok1337.taxation.data.data_source.termux.table.TaxTable
import com.kok1337.taxation.data.model.TaxApiModel
import com.kok1337.termux_database.api.DatabaseFactory
import org.ktorm.dsl.and
import org.ktorm.dsl.eq
import org.ktorm.entity.filter
import org.ktorm.entity.firstOrNull
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toList
import java.util.*

class TaxDao(
    private val databaseFactory: DatabaseFactory,
) {
    internal fun getById(id: UUID): TaxApiModel? {
        val database = databaseFactory.create()
        return database.sequenceOf(TaxTable)
            .filter { it.isDeleted eq false }
            .firstOrNull { it.id eq id }
    }

    internal fun getAllByLocalityIdAndSection(
        localityId: UUID,
        section: String
    ): Iterable<TaxApiModel> {
        val database = databaseFactory.create()
        return database.sequenceOf(TaxTable)
            .filter { it.isDeleted eq false }
            .filter { (it.localityId eq localityId) and (it.section eq section) }
            .toList()
    }
}