package com.kok1337.taxation.data.data_source.termux.table

import com.kok1337.taxation.data.model.NonForestLandApiModel
import org.ktorm.dsl.QueryRowSet
import org.ktorm.schema.BaseTable
import org.ktorm.schema.int
import org.ktorm.schema.text

internal object NonForestLandTable :
    BaseTable<NonForestLandApiModel>("info_non_forest_land", schema = "public") {
    val id = int("id").primaryKey()
    val name = text("name")
    override fun doCreateEntity(row: QueryRowSet, withReferences: Boolean): NonForestLandApiModel =
        NonForestLandApiModel(
            id = row[id]!!,
            name = row[name]!!,
        )
}