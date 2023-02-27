package com.kok1337.tax_layer_species.internal.datasource.database.entity

import com.kok1337.database.api.annotation.Column
import com.kok1337.database.api.annotation.Entity
import com.kok1337.tax_layer_species.api.TaxLayerSpeciesApiModel
import java.util.*

@Entity
internal class TaxLayerSpeciesEntity(
    @Column("id") var id: UUID? = null,
    @Column("parent_id") var parentId: UUID? = null,
    @Column("species_id") var speciesId: Int? = null,
    @Column("coeff") var coeff: Int? = null,
    @Column("age") var age: Int? = null,
    @Column("h") var height: Int? = null,
    @Column("d") var diameter: Int? = null,
    @Column("is_main") var isMain: Boolean? = null,
    @Column("name_short") var nameShort: String? = null,
    @Column("is_extra") var isExtra: Boolean? = null,
    @Column("name") var name: String? = null,
    @Column("species_num") var speciesNum: Int? = null,
    @Column("gen") var gen: Int? = null,
    @Column("stock") var stock: Int? = null,
    @Column("merchantability_group_id") var merchantabilityGroupId: Int? = null,
) {
    fun toModel(): TaxLayerSpeciesApiModel = TaxLayerSpeciesApiModel(
        id!!,
        parentId!!,
        speciesId,
        coeff,
        age,
        height,
        diameter,
        isMain,
        nameShort!!,
        isExtra ?: false,
        name!!,
        speciesNum,
        gen ?: 1,
        stock,
        merchantabilityGroupId
    )
}