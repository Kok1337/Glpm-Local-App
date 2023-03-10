package com.kok1337.address.data.data_source.termux.table

import com.kok1337.address.data.model.LocalForestryApiModel
import org.ktorm.dsl.QueryRowSet
import org.ktorm.schema.BaseTable
import org.ktorm.schema.int
import org.ktorm.schema.text

internal object LocalForestryTable :
    BaseTable<LocalForestryApiModel>("info_localforestries", schema = "public") {
    val id = int("id").primaryKey()
    val name = text("name")

    override fun doCreateEntity(row: QueryRowSet, withReferences: Boolean): LocalForestryApiModel =
        LocalForestryApiModel(
            id = row[id]!!,
            name = row[name]!!,
        )
}