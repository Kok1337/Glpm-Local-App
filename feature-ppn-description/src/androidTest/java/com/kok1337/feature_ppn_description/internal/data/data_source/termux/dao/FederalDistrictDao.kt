package com.kok1337.feature_ppn_description.internal.data.data_source.termux.dao

import com.kok1337.feature_ppn_description.api.data.model.FederalDistrictApiModel
import com.kok1337.feature_ppn_description.internal.data.data_source.termux.table.FederalDistricts
import org.ktorm.database.Database
import org.ktorm.dsl.eq
import org.ktorm.dsl.inList
import org.ktorm.entity.filter
import org.ktorm.entity.firstOrNull
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toList
import org.ktorm.support.postgresql.ilike
import javax.inject.Inject

internal class FederalDistrictDao @Inject constructor(
    private val database: Database,
) {
    fun getAll(): Iterable<FederalDistrictApiModel> {
        return database.sequenceOf(FederalDistricts)
            .toList()
    }

    fun getById(id: Int?): FederalDistrictApiModel? {
        if (id == null) return null
        return database.sequenceOf(FederalDistricts)
            .filter { it.id eq id }
            .firstOrNull()
    }

    fun getAllByIdsWithSearch(ids: List<Int>, search: String): Iterable<FederalDistrictApiModel> {
        return database.sequenceOf(FederalDistricts)
            .filter { it.id.inList(ids) }
            .filter { it.name ilike "%${search}%"  }
            .toList()
    }
}