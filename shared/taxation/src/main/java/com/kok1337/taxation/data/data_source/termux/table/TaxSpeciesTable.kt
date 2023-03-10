package com.kok1337.taxation.data.data_source.termux.table

import com.kok1337.taxation.data.model.TaxSpeciesApiModel
import org.ktorm.dsl.QueryRowSet
import org.ktorm.schema.*

internal object TaxSpeciesTable :
    BaseTable<TaxSpeciesApiModel>("info_tax_layer", schema = "public") {
    val id = uuid("id").primaryKey()
    val parentId = uuid("parent_id")
    val speciesId = int("species_id")
    val coeff = int("coeff")
    val age = int("age")
    val height = int("h")
    val diameter = int("d")
    val isMain = boolean("is_main")
    val nameShort = text("name_short")
    val isExtra = boolean("is_extra")
    val name = text("name")
    val speciesNum = int("species_num")
    val gen = int("gen")
    val stock = int("stock")
    val merchantabilityGroupId = int("merchantability_group_id")

    val userId = int("user_id")
    val modificationDate = timestamp("modification_date")
    val isDeleted = boolean("is_deleted")
    override fun doCreateEntity(row: QueryRowSet, withReferences: Boolean): TaxSpeciesApiModel =
        TaxSpeciesApiModel(
            id = row[id]!!,
            parentId = row[parentId]!!,
            speciesId = row[speciesId],
            coeff = row[coeff],
            age = row[age],
            height = row[height],
            diameter = row[diameter],
            isMain = row[isMain],
            nameShort = row[nameShort]!!,
            isExtra = row[isExtra]!!,
            name = row[name]!!,
            speciesNum = row[speciesNum],
            gen = row[gen]!!,
            stock = row[stock],
            merchantabilityGroupId = row[merchantabilityGroupId],
        )
}