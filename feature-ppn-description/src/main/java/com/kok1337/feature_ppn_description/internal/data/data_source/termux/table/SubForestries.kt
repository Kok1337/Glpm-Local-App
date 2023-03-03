package com.kok1337.feature_ppn_description.internal.data.data_source.termux.table

import com.kok1337.feature_ppn_description.api.data.model.SubForestryApiModel
import org.ktorm.dsl.QueryRowSet
import org.ktorm.schema.BaseTable
import org.ktorm.schema.int
import org.ktorm.schema.text

object SubForestries : BaseTable<SubForestryApiModel>("info_subforestries", schema = "public") {
    val id = int("id").primaryKey()
    val name = text("name")

    override fun doCreateEntity(row: QueryRowSet, withReferences: Boolean): SubForestryApiModel =
        SubForestryApiModel(
            id = row[Regions.id]!!,
            name = row[Regions.name]!!,
        )
}