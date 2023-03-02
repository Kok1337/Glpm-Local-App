package com.kok1337.feature_ppn_description.internal.data.data_source.termux.table

import com.kok1337.feature_ppn_description.api.data.model.FederalDistrictApiModel
import org.ktorm.dsl.QueryRowSet
import org.ktorm.schema.BaseTable
import org.ktorm.schema.int
import org.ktorm.schema.text

object FederalDistricts : BaseTable<FederalDistrictApiModel>("public.info_districts") {
    val id = int("id").primaryKey()
    val name = text("name")

    override fun doCreateEntity(
        row: QueryRowSet,
        withReferences: Boolean
    ): FederalDistrictApiModel = FederalDistrictApiModel(
        id = row[id]!!,
        name = row[name]!!,
    )
}