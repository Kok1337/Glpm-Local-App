package com.kok1337.feature_ppn_description.api.data.data_source.termux.table

import com.kok1337.feature_ppn_description.api.data.model.LocalityApiModel
import org.ktorm.dsl.QueryRowSet
import org.ktorm.schema.BaseTable
import org.ktorm.schema.int
import org.ktorm.schema.text
import org.ktorm.schema.uuid

internal object LocalityTable : BaseTable<LocalityApiModel>("info_locality", schema = "public") {
    val id = uuid("id").primaryKey()
    val federalDistrictId = int("fo_id")
    val regionId = int("region_id")
    val forestryId = int("forestry_id")
    val localForestryId = int("localforestry_id")
    val subForestryId = int("subforestry_id")
    val area = text("area")

    override fun doCreateEntity(row: QueryRowSet, withReferences: Boolean): LocalityApiModel {
        return LocalityApiModel(
            id = row[id]!!,
            federalDistrictId = row[federalDistrictId]!!,
            regionId = row[regionId]!!,
            forestryId = row[forestryId]!!,
            localForestryId = row[localForestryId]!!,
            subForestryId = row[subForestryId]!!,
            area = row[area]!!,
        )
    }
}