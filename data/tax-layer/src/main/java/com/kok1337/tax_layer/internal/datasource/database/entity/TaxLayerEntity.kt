package com.kok1337.tax_layer.internal.datasource.database.entity

import com.kok1337.database.api.annotation.Column
import com.kok1337.database.api.annotation.Entity
import com.kok1337.tax_layer.api.TaxLayerApiModel
import java.util.*

@Entity
internal class TaxLayerEntity(
    @Column("id") var id: UUID? = null,
    @Column("parent_id") var parentId: UUID? = null,
    @Column("layer") var layer: Int? = null,
    @Column("composition") var composition: String? = null,
    @Column("fullness") var fullness: Double? = null,
    @Column("stock") var stock: Double? = null,
    @Column("age_class") var ageClass: Int? = null,
    @Column("age_group_id") var ageGroupId: Int? = null,
    @Column("h") var height: Int? = null,
    @Column("layer_type_id") var layerTypeId: Int? = null,
    @Column("age") var age: Int? = null,
    @Column("density") var density: Double? = null,
    @Column("condition") var condition: String? = null,
) {
    fun toModel(): TaxLayerApiModel = TaxLayerApiModel(
        id!!,
        parentId!!,
        layer,
        composition,
        fullness,
        stock,
        ageClass,
        ageGroupId,
        height,
        layerTypeId,
        age,
        density,
        condition
    )
}
