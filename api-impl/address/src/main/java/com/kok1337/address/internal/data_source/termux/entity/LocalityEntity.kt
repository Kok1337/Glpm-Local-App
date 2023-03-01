package com.kok1337.address.internal.data_source.termux.entity

import com.kok1337.database.api.annotation.Column
import com.kok1337.database.api.annotation.Entity
import java.util.*

@Entity
internal class LocalityEntity(
    @Column("id") var id: UUID? = null,
    @Column("fo_id") var districtId: Int? = null,
    @Column("region_id") var regionId: Int? = null,
    @Column("forestry_id") var forestryId: Int? = null,
    @Column("localforestry_id") var localForestryId: Int? = null,
    @Column("subforestry_id") var subForestryId: Int? = null,
    @Column("area") var area: String? = null,
)