package com.kok1337.address.internal.data_source.termux.entity

import com.kok1337.database.api.annotation.Column
import com.kok1337.database.api.annotation.Entity

@Entity
internal class RegionEntity(
    @Column("id") var id: Int? = null,
    @Column("name") var name: String? = null,
)