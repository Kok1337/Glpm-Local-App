package com.kok1337.taxation.data.data_source.termux.table

import com.kok1337.taxation.data.model.UnforestedLandApiModel
import org.ktorm.dsl.QueryRowSet
import org.ktorm.schema.BaseTable
import org.ktorm.schema.int
import org.ktorm.schema.text

internal object UnforestedLandTable :
    BaseTable<UnforestedLandApiModel>("info_unforested_land", schema = "public") {
    val id = int("id").primaryKey()
    val name = text("name")
    override fun doCreateEntity(row: QueryRowSet, withReferences: Boolean): UnforestedLandApiModel =
        UnforestedLandApiModel(
            id = row[id]!!,
            name = row[name]!!,
        )
}