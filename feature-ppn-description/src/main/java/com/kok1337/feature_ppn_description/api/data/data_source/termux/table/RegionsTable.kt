package com.kok1337.feature_ppn_description.api.data.data_source.termux.table

import com.kok1337.feature_ppn_description.api.data.model.RegionApiModel
import org.ktorm.dsl.QueryRowSet
import org.ktorm.schema.BaseTable
import org.ktorm.schema.int
import org.ktorm.schema.text

internal object RegionsTable : BaseTable<RegionApiModel>("info_regions", schema = "public") {
    val id = int("id").primaryKey()
    val name = text("name")

    override fun doCreateEntity(
        row: QueryRowSet,
        withReferences: Boolean
    ): RegionApiModel =
        RegionApiModel(
            id = row[id]!!,
            name = row[name]!!,
        )
}