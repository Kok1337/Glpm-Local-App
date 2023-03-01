package com.kok1337.address.internal.data_source.termux.mapper

import com.kok1337.address.api.model.District
import com.kok1337.address.api.model.Forestry
import com.kok1337.address.api.model.LocalForestry
import com.kok1337.address.api.model.Region
import com.kok1337.address.internal.data_source.termux.entity.*

object EntityMapper {
    fun map(districtEntity: DistrictEntity): District = District(
        id = districtEntity.id!!,
        name = districtEntity.name!!,
    )

    fun map(regionEntity: RegionEntity): Region = Region(
        id = regionEntity.id!!,
        name = regionEntity.name!!,
    )

    fun map(forestryEntity: ForestryEntity): Forestry = Forestry(
        id = forestryEntity.id!!,
        name = forestryEntity.name!!,
    )

    fun map(localForestryEntity: LocalForestryEntity): LocalForestry = LocalForestry(
        id = localForestryEntity.id!!,
        name = localForestryEntity.name!!,
    )

    fun map(subForestryEntity: SubForestryEntity): SubForestryEntity = SubForestryEntity(
        id = subForestryEntity.id,
        name = subForestryEntity.name ?: "(Нет)",
    )
}