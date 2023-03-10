package com.kok1337.taxation.data.data_source.termux.table

import com.kok1337.taxation.data.model.TaxLayerApiModel
import org.ktorm.dsl.QueryRowSet
import org.ktorm.schema.*

internal object TaxLayerTable : BaseTable<TaxLayerApiModel>("info_tax_layer", schema = "public") {
    val id = uuid("id").primaryKey()
    val parentId = uuid("parent_id")
    val layer = int("layer")
    val composition = text("composition")
    val fullness = double("fullness")
    val stock = double("stock")
    val ageClass = int("age_class")
    val ageGroupId = int("age_group_id")
    val height = int("h")
    val layerTypeId = int("layer_type_id")
    val age = int("age")
    val density = double("density")
    val condition = text("condition")

    val userId = int("user_id")
    val modificationDate = timestamp("modification_date")
    val isDeleted = boolean("is_deleted")
    override fun doCreateEntity(row: QueryRowSet, withReferences: Boolean): TaxLayerApiModel =
        TaxLayerApiModel(
            id = row[id]!!,
            parentId = row[parentId]!!,
            layer = row[layer],
            composition = row[composition],
            fullness = row[fullness],
            stock = row[stock],
            ageClass = row[ageClass],
            ageGroupId = row[ageGroupId],
            height = row[height],
            layerTypeId = row[layerTypeId] ?: 1,
            age = row[age],
            density = row[density],
            condition = row[condition],
        )
}