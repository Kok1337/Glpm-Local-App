package com.kok1337.address.data.data_source.termux.table

import com.kok1337.address.data.model.FederalDistrictApiModel
import org.ktorm.dsl.QueryRowSet
import org.ktorm.schema.BaseTable
import org.ktorm.schema.int
import org.ktorm.schema.text

internal object FederalDistrictTable :
    BaseTable<FederalDistrictApiModel>("info_districts", schema = "public") {
    val id = int("id").primaryKey()
    val name = text("name")

    override fun doCreateEntity(
        row: QueryRowSet,
        withReferences: Boolean
    ): FederalDistrictApiModel =
        FederalDistrictApiModel(
            id = row[id]!!,
            name = row[name]!!,
        )
}