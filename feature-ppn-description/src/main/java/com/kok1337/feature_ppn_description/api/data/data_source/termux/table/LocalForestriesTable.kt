package com.kok1337.feature_ppn_description.api.data.data_source.termux.table

import com.kok1337.feature_ppn_description.api.data.model.LocalForestryApiModel
import org.ktorm.dsl.QueryRowSet
import org.ktorm.schema.BaseTable
import org.ktorm.schema.int
import org.ktorm.schema.text

internal object LocalForestriesTable :
    BaseTable<LocalForestryApiModel>("info_localforestries", schema = "public") {
    val id = int("id").primaryKey()
    val name = text("name")

    override fun doCreateEntity(row: QueryRowSet, withReferences: Boolean): LocalForestryApiModel =
        LocalForestryApiModel(
            id = row[RegionsTable.id]!!,
            name = row[RegionsTable.name]!!,
        )
}